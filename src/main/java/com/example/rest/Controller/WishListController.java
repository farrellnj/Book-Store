package com.example.rest.Controller;

import com.example.rest.Models.*;
import com.example.rest.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WishListController {


    @Autowired
    private WishListService wishListService;

    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private BooksService booksService;


    @PostMapping("/createWishList")
    public String add(@RequestParam String wishListName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getUser(currentPrincipalName);

            WishList newWishList = new WishList();
            newWishList.setListName(wishListName);
            newWishList.setUserName(user.getUsername());
            wishListService.save(newWishList);
            return "Your new wishList " + wishListName + " has been created";
        }


    }



