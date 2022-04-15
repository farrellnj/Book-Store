package com.example.rest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String listName;

    @OneToMany(mappedBy = "wishList",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WishListItems> wishListItems;


}
