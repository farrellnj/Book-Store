package com.example.rest.Repo;


import com.example.rest.Models.WishListItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListItemsRepo extends JpaRepository<WishListItems, Integer> {

    List<WishListItems> findAllByWishListId(Integer wishListId);

    void deleteById(Integer id);

    WishListItems findOneByBooksIdAndWishListId(Integer booksId, Integer wishListId);
}
