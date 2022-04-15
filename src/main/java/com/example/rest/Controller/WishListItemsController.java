package com.example.rest.Controller;

import com.example.rest.Models.*;
import com.example.rest.Service.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WishListItemsController {

    @Autowired
    private WishListItemsService wishListItemsService;

    @Autowired
    private WishListService wishListService;

    @Autowired
    private UserService userService;

    @Autowired
    private BooksService booksService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/addWishListItem")
    public String addToCart(@RequestParam String bookName) {

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);
            user.getUsername();
            WishList wishList = wishListService.findWishList(user.getUsername());
            Books newBooks = booksService.getBookName(bookName);
            WishListItems newWishListItem = new WishListItems(wishList, newBooks);
            wishListItemsService.save(newWishListItem);
            return "WishList item has been added";
        }
        catch(Exception e){
            return "Book is not in our system";
        }

    }

    @DeleteMapping("/addWishListItemToCart")
    public String deleteBook(@RequestParam String bookName) {

        try {
            //Find the wishListid
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);

            WishList wishList = wishListService.findWishList(user.getUsername());
            Books book = booksService.getBookName(bookName);

            wishListItemsService.addToCart(wishList.getId(), book.getId());

            //Add the booktocart
            Cart cart = cartService.findCart(user.getUsername());
            CartItems newCartItem = new CartItems(cart, book);
            cartItemsService.save(newCartItem);
            //DeletebookfromwishList




            return "WishList item has been added to Cart";
        }
        catch(Exception e){
            return "Erorrr";
        }

    }


    @GetMapping("/getWishList")
    public List<CartBook> getWishList() throws Exception{
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userService.getUser(currentPrincipalName);
            user.getUsername();
            WishList wishList = wishListService.findWishList(user.getUsername());
            return wishListItemsService.getWishList(wishList.getId());

        }
        catch(Exception e){
            throw new Exception("Failed to retrieve wishList");
        }
    }
}
