package com.example.rest.Controller;

import com.example.rest.Models.Books;
import com.example.rest.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre/{genreName}")
    public List<Books> getBooksByGenre(@PathVariable String genreName){
        return genreService.findBooksByGenre(genreName);
    }
}
