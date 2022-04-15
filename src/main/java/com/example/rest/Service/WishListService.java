package com.example.rest.Service;

import com.example.rest.Models.Authors;
import com.example.rest.Models.WishList;
import com.example.rest.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private WishListRepo wishListRepo;

    public WishList findWishList(String userName){return wishListRepo.findOneByUserName(userName);}

    public void save(WishList wishList){
        wishListRepo.save(wishList);
    }
}
