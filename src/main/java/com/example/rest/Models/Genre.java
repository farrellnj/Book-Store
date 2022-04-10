package com.example.rest.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String genreName;

    //One genre can have many books
    //@JsonIgnore
    @OneToMany(mappedBy = "genre",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();

    public Genre(){

    }

    public Genre(String genreName, List<Books> books) {

        this.genreName = genreName;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
