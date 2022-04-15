package com.example.rest.Controller;


import com.example.rest.Models.Authors;

import com.example.rest.Models.Books;
import com.example.rest.Service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class AuthorsControllers {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping("/getAuthors")
    public List<Authors> list(){
        return authorsService.listAll();
    }

    @GetMapping("/getAuthors/{id}")
    public ResponseEntity<Authors> get(@PathVariable Integer id){
        try{
            Authors authors = authorsService.get(id);
            return new ResponseEntity<Authors>(authors, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
        }
    }

   @GetMapping("/getBooksByAuthor")
    public List<Books> getBooksByAuthor(@RequestParam String lastName, @RequestParam String firstName ){
        return authorsService.findBooksByAuthor(lastName, firstName);
    }


    @PostMapping("/saveAuthor")
    public String add(@RequestBody Authors authors){
        authorsService.save(authors);
        return "Author had been Saved!";
    }




}
