package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.Reviews;
import com.example.rest.Repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepo bookRepo;

    public Page<Books> listAll(Optional<Integer> page){
        return bookRepo.findAll(PageRequest.of(page.orElse(0), 5));
    }

    public void save(Books books){
        bookRepo.save(books);
    }

    public Books getIsbn(Integer isbn){
        return bookRepo.findOneByIsbn(isbn);
    }

    public Books getBookName(String bookName){return bookRepo.findOneByBookName(bookName);}

    public Books get(Integer id){
        return bookRepo.findById(id).get();
    }

    public List<Books> getByRating(Integer averageRating){return bookRepo.findByAverageRatingLessThanEqual(averageRating);}


    public boolean checkExists(Integer isbn){
        return bookRepo.existsByIsbn(isbn);
    }

    public Books[] getTopSellersList(){
        Books[] booksTopSellers = new Books[10];
        List<Books> books = bookRepo.findAllByOrderByCopiesSoldDesc();

        for(int i = 0; i < booksTopSellers.length; i++){
            booksTopSellers[i] = books.get(i);
        }
        return booksTopSellers;
    }

}
