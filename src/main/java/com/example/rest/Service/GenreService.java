package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.Genre;
import com.example.rest.Repo.BooksRepo;
import com.example.rest.Repo.GenreRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class GenreService {

    @Autowired
    private GenreRepo genreRepo;

    public List<Genre> listAll(){
        return genreRepo.findAll();
    }

    public Genre findGenre(String genreName){
        return genreRepo.findOneByGenreName(genreName);
    }

    public List<Books> findBooksByGenre(String genreName){

        Genre currentGenre = genreRepo.findOneByGenreName(genreName);

        return currentGenre.getBooks();


    }

    public Genre saveGenre(Genre genre){
        log.info("Saving genre to {} to the database", genre.getGenreName());
        return genreRepo.save(genre);
    }
}
