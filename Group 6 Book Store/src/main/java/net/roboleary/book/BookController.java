package net.roboleary.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping ("/books")
public class BookController {
    List<Book> books = new ArrayList<Book>();

    //We create data to use in our Controller. You can learn how to get the data from a database later, which is
    //usually the case!
    public BookController(){
        books.add(new Book("1451673310", "Fahrenheit 451", "Guy Montag is a fireman. His job is to destroy the most illegal of commodities, the printed book...", 10, "Ray Bradbury", "fiction", "Simon & Schuster", 2012, 2000000));
        books.add(new Book("0451524934", "1984", "Winston Smith toes the Party line, rewriting history to satisfy the demands of the Ministry of Truth", 8, "George Orwell", "fiction", "Signet Classic", 1961, 3000000));
        books.add(new Book("0143039431", "The Grapes of Wrath", "Pulitzer Prize winning epic of the Great Depression chronicles the Dust Bowl migration of the 1930s", 13, "John Steinbeck", "fiction", "Penguin Classics", 2006, 900000));
    }

    //GET for http://localhost:8080/books . Returns all books. Alternatively, you can use @GetMapping
    //@RequestMapping(method=GET, value="/books")
    @GetMapping
    public List<Book> getBooks(){
        return books;
    }

    //GET for http://localhost:8080/books/isbn .Returns all books with the isbn provided
    @GetMapping(value="/{isbn}")
    public ResponseEntity getBooksByIsbn(@PathVariable("isbn") String isbn){
        Book bookFound = null;

        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                bookFound = book;
                break;
            }
        }

        if (bookFound == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //found
        return new ResponseEntity(bookFound, HttpStatus.OK);
    }

    //GET for http://localhost:8080/book?name=rob oleary .Returns all books with the name provided
    @GetMapping(params = "name")
    public ResponseEntity getBooksByName(@RequestParam(value="name") String name){
        List<Book> filteredBooks = new ArrayList<Book>();

        for(Book book: books){
            if(book.getName().equalsIgnoreCase(name)) {
                filteredBooks.add(book);
            }
        }

        if (filteredBooks.isEmpty() == true) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //found
        return new ResponseEntity(filteredBooks, HttpStatus.OK);
    }

    //GET for http://localhost:8080/books?genre=fiction .Returns all books with the age provided
    @GetMapping(params= "genre")
    public ResponseEntity getBooksByGenre(@RequestParam(value="genre") String genre){
        List<Book> filteredBooks = new ArrayList<Book>();

        for(Book book: books){
            if(book.getGenre().equals(genre)) {
                filteredBooks.add(book);
            }
        }

        if (filteredBooks.isEmpty() == true) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //found
        return new ResponseEntity(filteredBooks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Book u) {
        books.add(u);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity addOrUpdate(@RequestBody Book u) {
        ResponseEntity response;

        if(books.contains(u)){
            //update by setting it at the specified position
            int index = books.indexOf(u);
            books.set(index, u);
            response = new ResponseEntity(u, HttpStatus.OK);
        }
        else{
            books.add(u);
            response = new ResponseEntity(u, HttpStatus.CREATED);
        }

        return response;
    }


    @DeleteMapping(value="/{isbn")
    public ResponseEntity delete(@PathVariable("isbn") String isbn) {
        boolean found = false;

        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                books.remove(book);
                found = true;
                break;
            }
        }

        if (found == false) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //found
        return new ResponseEntity(HttpStatus.OK);
    }
}

