package com.example.rest.Repo;

import com.example.rest.Models.Books;
import com.example.rest.Models.CartItems;
import com.example.rest.Models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface CartItemsRepo extends JpaRepository<CartItems, Integer> {

    List<CartItems> findAllByCartId(Integer cardId);



}
