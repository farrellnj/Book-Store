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
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @OneToMany(mappedBy = "cart",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CartItems> cartItems;



}
