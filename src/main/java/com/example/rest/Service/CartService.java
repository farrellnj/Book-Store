package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Cart;
import com.example.rest.Repo.AuthorsRepo;
import com.example.rest.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public Cart findCart(String userName){
        return cartRepo.findOneByUserName(userName);
    }
}
