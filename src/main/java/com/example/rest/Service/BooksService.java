package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepo bookRepo;

    public List<Books> listAll(){
        return bookRepo.findAll();
    }

    public void save(Books books){
        bookRepo.save(books);
    }

    public Books getIsbn(Integer isbn){
        return bookRepo.findOneByIsbn(isbn);
    }

    public Books get(Integer id){
        return bookRepo.findById(id).get();
    }

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
