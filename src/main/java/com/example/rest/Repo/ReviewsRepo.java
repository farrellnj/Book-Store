package com.example.rest.Repo;

import com.example.rest.Models.Books;
import com.example.rest.Models.Reviews;
import com.example.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepo extends JpaRepository<Reviews, Integer> {


    List<Reviews> findAllByOrderByRatingDesc();
}
