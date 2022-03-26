package com.example.rest.Models;

public class AutBookWrapper {


    private Authors authors;

    private Books books;


    public AutBookWrapper(Authors authors, Books books) {
        this.authors = authors;
        this.books = books;
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
}
