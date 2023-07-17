package com.berbus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String titel;

    private String description;

    private boolean isReserved;

    private boolean isPrivate;

//TODO configure the prices to only have 2 decimal places (Nachkommastellen)
    private double grossPrice;

    private double netPrice;

    private double originalPrice;

    private int amount;

    private String sellerEmail;

    private String account;

    private int accountQueue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;
}
