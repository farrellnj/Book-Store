package com.example.rest.Controller;

import com.example.rest.Models.AutBookWrapper;
import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.Genre;
import com.example.rest.Service.AuthorsService;
import com.example.rest.Service.BooksService;
import com.example.rest.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/getBooks")
    public Page<Books> list(@RequestParam Optional<Integer> pages){
        return booksService.listAll(pages);
    }


    @GetMapping("getBooks/{isbn}")
    public Books getIsbn(@PathVariable Integer isbn){

            Books books = booksService.getIsbn(isbn);
            return books;
    }

    @GetMapping("/getBooks/topSellers")
    public Books[] getTopSellers(){

        return booksService.getTopSellersList();
    }

    @GetMapping("/getBooks/byRating/{rating}")
    public List<Books> getByRating(@PathVariable Integer rating){

        return booksService.getByRating(rating);
    }

    /*@GetMapping("/getBooks/{isbn}")
    public ResponseEntity<Books> getIsbn(@PathVariable Integer isbn){
        try{
            Books books = booksService.getIsbn(isbn);
            return new ResponseEntity<Books>(books, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/saveBook")
    public String add(@RequestBody AutBookWrapper autBook){


        Authors newAuthors = autBook.getAuthors();
        Books newBooks = autBook.getBooks();
        Genre newGenre = autBook.getGenre();

        //If author is not in system and book already is
        if(!authorsService.checkExists(newAuthors.getLastName(), newAuthors.getFirstName()) && booksService.checkExists(newBooks.getIsbn()) && booksService.checkExistsByBookName(newBooks.getBookName()))
        {
            authorsService.save(newAuthors);
            return "Author entry has been saved! Book already in system";
        }
        //If author is in system and book is not
        else if(authorsService.checkExists(newAuthors.getLastName(), newAuthors.getFirstName()) && !booksService.checkExists(newBooks.getIsbn()) && !booksService.checkExistsByBookName(newBooks.getBookName())){
            //If author already exists find key and update for newBook\
            newBooks.setAuthors(authorsService.findAuthor(newAuthors.getLastName(), newAuthors.getFirstName()));
            newBooks.setGenre(genreService.findGenre(newGenre.getGenreName()));
            booksService.save(newBooks);
            newAuthors.getBooks().add(newBooks);
            newGenre.getBooks().add(newBooks);
            return "New Book entry has been saved! Author already in system";
        }
        else if(authorsService.checkExists(newAuthors.getLastName(), newAuthors.getFirstName()) && booksService.checkExists(newBooks.getIsbn()) && booksService.checkExistsByBookName(newBooks.getBookName())){
            return "Both author and Book are already in system!";
        }
        else{
            authorsService.save(newAuthors);
            newBooks.setAuthors(newAuthors);
            newBooks.setGenre(genreService.findGenre(newGenre.getGenreName()));
            booksService.save(newBooks);
            newAuthors.getBooks().add(newBooks);
            newGenre.getBooks().add(newBooks);
            return "New Book and Author entry have been Saved!";
        }


    }



}
