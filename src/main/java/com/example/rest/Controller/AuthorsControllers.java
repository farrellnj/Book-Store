package com.example.rest.Controller;


import com.example.rest.Models.Authors;

import com.example.rest.Service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
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

    @GetMapping("/author/{id}")
    public ResponseEntity<Authors> get(@PathVariable Integer id){
        try{
            Authors authors = authorsService.get(id);
            return new ResponseEntity<Authors>(authors, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveAuthor")
    public String add(@RequestBody Authors authors){
        authorsService.save(authors);
        return "Author had been Saved!";
    }



}
