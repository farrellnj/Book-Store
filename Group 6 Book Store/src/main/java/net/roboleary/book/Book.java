package net.roboleary.book;

public class Book {
    private String isbn;
    private String name;
    private String description;
    private int price;
    private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;

    //you must include this when you have a POST or PUT, Spring needs to be able to create an empty object
    public Book(){}

    public Book(String isbn, String name, String description, int price, String author, String genre, String publisher, int yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    //generated through IntelliJ. Equals and hashCode are important for object comparsion, so when we want to see
    //if we should delete an object from an array, we need to know if it the right object.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return getIsbn() == book.getIsbn();
    }

    @Override
    public int hashCode() {
        //return (int) (getIsbn() ^ (getIsbn() >>> 32));
        return (int) (getPrice() ^ (getPrice() >>> 32));
    }
}
