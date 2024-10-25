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
public class ReviewFood {
    private int id;
    private int rating;
    private String comment;
    private int food_id;
    private int account_id;
    private String createDate;
    private Food food;
    private Account account;

    public ReviewFood(int id, int rating, String comment, int food_id, int account_id, String createDate) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.food_id = food_id;
        this.account_id = account_id;
        this.createDate = createDate;
        this.food = new DAO().getFood(food_id);
        this.account = new DAO().getAccount(account_id);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    
}
