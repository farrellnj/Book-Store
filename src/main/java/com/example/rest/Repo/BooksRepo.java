package com.example.rest.Repo;

import com.example.rest.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BooksRepo extends JpaRepository<Books, Integer> {

    Books findOneByIsbn (Integer isbn);

    boolean existsByIsbn(Integer isbn);




}
