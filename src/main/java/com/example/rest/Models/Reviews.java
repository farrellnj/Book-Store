package com.example.rest.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter @Setter @NoArgsConstructor
public class Reviews {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String review;
    private String bookName;

    //Many Reviews to on book
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Books books;


    public Reviews(String bookName, Integer rating, String review) {
        this.bookName = bookName;
        this.rating = rating;
        this.review = review;

    }
}
