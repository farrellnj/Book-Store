package com.example.rest.Service;

import com.example.rest.Models.*;
import com.example.rest.Repo.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Log4j2
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByUsername(username);
       if(user == null){
           log.error("User not found in the database");
           throw new UsernameNotFoundException("User not found in the database");
       } else{
           log.info("User found in the database: {}", username);
       }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
       user.getRoles().forEach(role ->{
           authorities.add(new SimpleGrantedAuthority((role.getName())));
       });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Cart newCart = new Cart();
        newCart.setUserName(user.getUsername());
        cartRepo.save(newCart);

        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }


    public String addBookToWishList(String userName, String bookName){
       try {
           User user = userRepo.findByUsername(userName);
           Books book = booksRepo.findOneByBookName(bookName);

           return "Book has been added to WishList";
       }
        catch(Exception e){
           return "Error";
        }
    }


}
