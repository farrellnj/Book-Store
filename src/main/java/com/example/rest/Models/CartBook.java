package com.example.rest.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class CartBook {

    private String bookName;
    private String bookDescription;
    private int isbn;
    private int price;
    private int yearPublished;
    private int copiesSold;

    public CartBook(String bookName, String bookDescription, int isbn, int price, int yearPublished, int copiesSold) {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.isbn = isbn;
        this.price = price;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }
}
