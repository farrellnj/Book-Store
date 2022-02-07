package com.group6.Book_Store;

import com.roboleary.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping ("/books")
public class BookController {
    List<Book> book = new ArrayList<Book>();

    public BookController(){
        users.add(new Book("1451673310", "Fahrenheit 451", "Guy Montag is a fireman. His job is to destroy the most illegal of commodities, the printed book...", "$10", "Ray Bradbury", "fiction", "Simon & Schuster", 2012, 2000000));
        users.add(new Book("0451524934", "1984", "Winston Smith toes the Party line, rewriting history to satisfy the demands of the Ministry of Truth", "$8", "George Orwell", "fiction", "Signet Classic", 1961, 3000000));
        users.add(new Book("0143039431", "The Grapes of Wrath", "Pulitzer Prize winning epic of the Great Depression chronicles the Dust Bowl migration of the 1930s", "$13", "John Steinbeck", "fiction", "Penguin Classics", 2006, 900000));
    }

    //for GET to http://localhost:8080/users
    @GetMapping
    public List<Book> getBooks(){ 
        return books;
    }
  }
