package com.example.rest.Controller;

import com.example.rest.Models.AutBookWrapper;
import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Service.AuthorsService;
import com.example.rest.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/getBooks")
    public List<Books> list(){
        return booksService.listAll();
    }


    @GetMapping("/getBooks/{isbn}")
    public Books getIsbn(@PathVariable Integer isbn){

            Books books = booksService.getIsbn(isbn);
            return books;
    }


    /*@GetMapping("/getBooks/{isbn}")
    public ResponseEntity<Books> getIsbn(@PathVariable Integer isbn){
        try{
            Books books = booksService.getIsbn(isbn);
            return new ResponseEntity<Books>(books, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/saveBook")
    public String add(@RequestBody AutBookWrapper autBook){


        Authors newAuthors = autBook.getAuthors();
        Books newBooks = autBook.getBooks();
        //Checks to see if lastName exists in database
        if(!authorsService.checkExists(newAuthors.getLastName(), newAuthors.getFirstName()))
        {
            authorsService.save(newAuthors);
        }
        else{
            //If author already exists find key and update for newBook
            newBooks.setAuthors(authorsService.findAuthor(newAuthors.getLastName(), newAuthors.getFirstName()));
            booksService.save(newBooks);
            return "New Book entry has been saved! Author already in system";
        }
        newBooks.setAuthors(newAuthors);
        booksService.save(newBooks);
        return "New Book and Author entry have been Saved!";
    }

}
