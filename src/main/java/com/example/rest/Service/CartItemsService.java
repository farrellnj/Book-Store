package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.Books;
import com.example.rest.Models.CartBook;
import com.example.rest.Models.CartItems;
import com.example.rest.Repo.AuthorsRepo;
import com.example.rest.Repo.CartItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemsService {


    @Autowired
    private CartItemsRepo cartItemsRepo;


    public void save(CartItems cartItems) {
        cartItemsRepo.save(cartItems);
    }

    public List<CartBook> getCart(Integer cartId){
        List<CartItems> theList = cartItemsRepo.findAllByCartId(cartId);

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
