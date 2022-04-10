package com.example.rest.Service;


import com.example.rest.Models.Books;
import com.example.rest.Models.Reviews;
import com.example.rest.Repo.BooksRepo;
import com.example.rest.Repo.ReviewsRepo;
import com.example.rest.Repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReviewsService {

    @Autowired
    private ReviewsRepo reviewsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BooksRepo booksRepo;


    public void saveReview(Reviews reviews){
        log.info("Saving review {} to the database", reviews.getReview());
        Books books = booksRepo.findOneByBookName(reviews.getBookName());
        books.getReviews().add(reviews);
        books.setRatingCounter(books.getRatingCounter() + 1);
        books.setSumRating(books.getSumRating() + reviews.getRating());
        books.setAverageRating(books.getSumRating() / books.getRatingCounter());
        reviewsRepo.save(reviews);

    }
}
