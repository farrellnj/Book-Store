package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.Genre;
import com.example.rest.Repo.BooksRepo;
import com.example.rest.Repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
