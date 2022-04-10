package com.example.rest.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Authors {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;

    //One author can have many books
    //@JsonIgnore
    @OneToMany(mappedBy = "authors",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();

    public Authors(){

    }

    public Authors(Integer id, String firstName, String lastName, String biography, String publisher, List<Books> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this. publisher = publisher;
        this.books = books;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }




}
