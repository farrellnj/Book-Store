package com.example.rest.Models;



import javax.persistence.*;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="genre_id")
    private Genre genre;

    private int publisherID;
    private int isbn;
    private String description;
    private int price;
    private int yearPublished;
    private int copiesSold;


    //Many books to one author
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Authors authors;


    public Books() {
    }

    public Books(String bookName, Genre genre, int publisherID, int isbn, String description, int price, int yearPublished, int copiesSold, Authors authors) {
        this.bookName = bookName;
        this.genre = genre;
        this.publisherID = publisherID;
        this.isbn = isbn;
        this.description = description;
        this.price = price;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
