package com.example.rest.Repo;

import com.example.rest.Models.Cart;
import com.example.rest.Models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList, Integer> {

    WishList findOneByUserName(String userName);
}
