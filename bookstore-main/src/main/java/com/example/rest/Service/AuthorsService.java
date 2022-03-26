package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Repo.AuthorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepo authorsRepo;

    public List<Authors> listAll(){
        return authorsRepo.findAll();
    }

    public void save(Authors authors){
        authorsRepo.save(authors);
    }

    public Authors get(Integer id){
        return authorsRepo.findById(id).get();
    }

    public boolean checkExists(String lastName, String firstName){
        return authorsRepo.existsByLastNameAndFirstName(lastName, firstName);
    }

    public Authors findAuthor(String lastName, String firstName){
        return authorsRepo.findOneByLastNameAndFirstName(lastName, firstName);
    }

    //public List<Books> findBy
}
