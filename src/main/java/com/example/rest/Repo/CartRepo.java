package com.example.rest.Repo;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {

    Cart findOneByUserName(String userName);

}
