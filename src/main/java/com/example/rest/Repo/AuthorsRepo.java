package com.example.rest.Repo;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

//Integer is type of primary key

public interface AuthorsRepo extends JpaRepository<Authors, Integer> {

    boolean existsByLastNameAndFirstName(String lastName, String firstName);

    Authors findOneByLastNameAndFirstName(String lastName, String firstName);

    //List<Books> findByAuthorId(Integer authorId);


}
