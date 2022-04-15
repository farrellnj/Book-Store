package com.example.rest.Repo;

import com.example.rest.Models.Cart;
import com.example.rest.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {
}
