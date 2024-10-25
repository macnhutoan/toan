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
public class Food {
    private int id;
    private String name;
    private String image;
    private int restaurant_id;
    private String detail;
    private int price;
    private int status;
    private Restaurant restaurant;
    private int rating;
    private int numberComment;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNumberComment() {
        return numberComment;
    }

    public void setNumberComment(int numberComment) {
        this.numberComment = numberComment;
    }

    public Food(int id, String name, String image, int restaurant_id, String detail, int price,int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.restaurant_id = restaurant_id;
        this.detail = detail;
        this.price = price;
        this.status = status;
        this.restaurant = new DAO().getRestaurant(restaurant_id);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
