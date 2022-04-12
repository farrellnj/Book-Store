package com.example.rest.Controller;

import com.example.rest.Models.*;
import com.example.rest.Service.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CartItemsController
{

    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private BooksService booksService;

    @PostMapping("/addCartItem")
    public String save(@RequestParam String bookName) {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);
            user.getUsername();
            Cart cart = cartService.findCart(user.getUsername());
            Books newBooks = booksService.getBookName(bookName);
            CartItems newCartItem = new CartItems(cart, newBooks);
            cartItemsService.save(newCartItem);
            return "Cart item has been added";
        }
        catch(Exception e){
            return "Book is not in our system";
        }

    }

    @GetMapping("/getCart")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    public List<CartBook> getCart() throws Exception{
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);
            user.getUsername();
            Cart cart = cartService.findCart(user.getUsername());
            return cartItemsService.getCart(cart.getId());

        }
        catch(Exception e){
            throw new Exception("Failed to retrieve cart");
        }
    }
}
