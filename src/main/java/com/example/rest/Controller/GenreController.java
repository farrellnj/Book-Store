package com.example.rest.Controller;

import com.example.rest.Models.Books;
import com.example.rest.Models.Genre;
import com.example.rest.Models.User;
import com.example.rest.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre/{genreName}")
    public List<Books> getBooksByGenre(@PathVariable String genreName){
        return genreService.findBooksByGenre(genreName);
    }

    @PostMapping("/genre/save")
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(genreService.saveGenre(genre));
    }
}
