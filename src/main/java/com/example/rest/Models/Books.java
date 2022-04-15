package com.example.rest.Models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties({"genre", "authors"})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    private int ratingCounter;
    private int publisherID;
    private int isbn;
    private String description;
    private int price;
    private int yearPublished;
    private int copiesSold;

    @OneToMany(mappedBy = "books", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reviews> reviews = new ArrayList<>();

    private int averageRating;
    private int sumRating;
    

    //Many books to one author
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Authors authors;

    public Books(String bookName, Genre genre, int publisherID, int isbn, String description, int price, int yearPublished, int copiesSold, Authors authors, Reviews reviews) {
        this.bookName = bookName;
        this.genre = genre;
        this.publisherID = publisherID;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.authors = authors;
        this.reviews = (List<Reviews>) reviews;
        this.ratingCounter = ((List<?>) reviews).size();
    }
}