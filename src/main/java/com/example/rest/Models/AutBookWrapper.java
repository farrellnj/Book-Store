package com.example.rest.Models;

public class AutBookWrapper {


    private Authors authors;

    private Books books;

    private Genre genre;



    public AutBookWrapper(Authors authors, Books books, Genre genre) {
        this.authors = authors;
        this.books = books;
        this.genre = genre;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}


