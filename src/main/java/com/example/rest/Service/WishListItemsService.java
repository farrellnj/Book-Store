package com.example.rest.Service;

import com.example.rest.Models.CartBook;
import com.example.rest.Models.CartItems;
import com.example.rest.Models.WishList;
import com.example.rest.Models.WishListItems;
import com.example.rest.Repo.WishListItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListItemsService {

    @Autowired
    private WishListItemsRepo wishListItemsRepo;

    public void save(WishListItems wishListItems) {
       wishListItemsRepo.save(wishListItems);
    }

    public void addToCart(Integer wishListId, Integer booksId){
        WishListItems temp = wishListItemsRepo.findOneByBooksIdAndWishListId(booksId, wishListId);
        wishListItemsRepo.deleteById(temp.getId());
    }

    public List<CartBook> getWishList(Integer wishListId){
        List<WishListItems> theList = wishListItemsRepo.findAllByWishListId(wishListId);

        List<CartBook> bookList = new ArrayList<>();

        for(int i = 0; i < theList.size(); i++){
            String bookName = theList.get(i).getBooks().getBookName();
            String bookDescription = theList.get(i).getBooks().getBookName();
            int isbn = theList.get(i).getBooks().getIsbn();
            int price = theList.get(i).getBooks().getPrice();
            int yearPublished = theList.get(i).getBooks().getYearPublished();
            int copiesSold = theList.get(i).getBooks().getCopiesSold();
            CartBook newBook = new CartBook(bookName, bookDescription, isbn, price, yearPublished, copiesSold);
            bookList.add(newBook);
        }
        return bookList;

    }

}
