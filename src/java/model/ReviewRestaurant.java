/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DAO;

/**
 *
 * @author SHD
 */
public class ReviewRestaurant {
    private int id;
    private int rating;
    private String comment;
    private int account_id;
    private int restaurant_id;
    private String createDate;
    private Account account;

    public ReviewRestaurant(int id, int rating, String comment, int restaurant_id , int account_id, String createDate) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.account_id = account_id;
        this.restaurant_id = restaurant_id;
        this.createDate = createDate;
        this.account = new DAO().getAccount(account_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
}
