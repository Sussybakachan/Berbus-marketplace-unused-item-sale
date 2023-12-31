package com.berbus.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titel;

    private String description;

    private boolean isReserved;

    private boolean isPrivate;

    // TODO configure the prices to only have 2 decimal places (Nachkommastellen)
    private double grossPrice;

    private double netPrice;

    private double originalPrice;

    private int amount;

    private String sellerEmail;

    private String account;

    private int accountQueue;

    private String Image;

    public Product(Integer id, String titel, String description, boolean isReserved, boolean isPrivate, double grossPrice, double netPrice, double originalPrice, int amount, String sellerEmail, String account, int accountQueue, String Image, Category category) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.isReserved = isReserved;
        this.isPrivate = isPrivate;
        this.grossPrice = grossPrice;
        this.netPrice = netPrice;
        this.originalPrice = originalPrice;
        this.amount = amount;
        this.sellerEmail = sellerEmail;
        this.account = account;
        this.accountQueue = accountQueue;
        this.Image = Image;
        this.category = category;
    }

    public boolean isIsReserved() {
        return this.isReserved;
    }

    public boolean getIsReserved() {
        return this.isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public boolean isIsPrivate() {
        return this.isPrivate;
    }

    public boolean getIsPrivate() {
        return this.isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getImage() {
        return this.Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAccountQueue() {
        return accountQueue;
    }

    public void setAccountQueue(int accountQueue) {
        this.accountQueue = accountQueue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

}
