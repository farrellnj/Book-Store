package com.example.rest.Controller;

import com.example.rest.Models.CreditCard;
import com.example.rest.Models.Reviews;
import com.example.rest.Models.User;
import com.example.rest.Service.CreditCardService;
import com.example.rest.Service.ReviewsService;
import com.example.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private UserService userService;

    @PostMapping("/creditCard/save")
    public String save(@RequestBody CreditCard creditCard, @RequestParam String userName) {

        try {

            creditCardService.saveCreditCard(creditCard, userName);
            return "CreditCard has been added";
        }
        catch(Exception e){
            return "Information is Incorrect";
        }

    }
}
