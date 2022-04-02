package com.example.rest.Repo;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Integer> {

    Genre findOneByGenreName(String genreName);
}
