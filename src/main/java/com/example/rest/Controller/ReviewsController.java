package com.example.rest.Controller;

import com.example.rest.Models.Reviews;
import com.example.rest.Service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class ReviewsController {


    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/reviews/save")
   public void save(@RequestBody Reviews reviews){
        reviewsService.saveReview(reviews);
    }
}
