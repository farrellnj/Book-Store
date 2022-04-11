package com.example.rest.Controller;

import com.example.rest.Models.Books;
import com.example.rest.Models.Reviews;
import com.example.rest.Models.User;
import com.example.rest.Service.ReviewsService;
import com.example.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewsController {


    @Autowired
    private ReviewsService reviewsService;

    @Autowired
    private UserService userService;

    @GetMapping("/getReviews/highestRating")
    public List<Reviews> getHighestRating(){
        return reviewsService.listReviewsHighestToLowest();
    }


    @PostMapping("/reviews/save")
    public String save(@RequestBody Reviews reviews) {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);
            user.getReviews().add(reviews);
            reviewsService.saveReview(reviews);
            return "Review has been added";
        }
        catch(Exception e){
            return "Please login";
        }

    }
}
