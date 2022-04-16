package com.example.rest.Service;

import com.example.rest.Models.Books;
import com.example.rest.Models.CreditCard;
import com.example.rest.Models.Reviews;
import com.example.rest.Models.User;
import com.example.rest.Repo.CreditCardRepo;
import com.example.rest.Repo.ReviewsRepo;
import com.example.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepo creditCardRepo;

    @Autowired
    private UserRepo userRepo;

    public void saveCreditCard(CreditCard creditCard, String userName){
        User user = userRepo.findByUsername(userName);
        user.getCreditCard().add(creditCard);
        creditCard.setUser(user);
        creditCardRepo.save(creditCard);

    }

    public List<CreditCard> getCreditCards(String userName){
        User user = userRepo.findByUsername(userName);
        return user.getCreditCard();
    }


}
