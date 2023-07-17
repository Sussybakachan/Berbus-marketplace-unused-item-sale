package com.berbus;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private int categoryId;

private String categoryName;

private String categoryDescription;
}
