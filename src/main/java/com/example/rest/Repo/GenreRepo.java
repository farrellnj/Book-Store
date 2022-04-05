package com.example.rest.Repo;


import com.example.rest.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Integer> {

    Genre findOneByGenreName(String genreName);

}
