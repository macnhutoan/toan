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
 public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String image;
    private String detail;
    private int cate_id;
    private int location_id;
    private int status;
    private Category category;
    private int rating;
    private int numberComment;
    private Location location;
    private int owner_id;

    

    public Restaurant() {
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
    

    public Restaurant(int id, String name, String address, String phone, String image, String detail, int cate_id,int status,int location_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.detail = detail;
        this.cate_id = cate_id;
        this.category = new DAO().getCategory(cate_id);
        this.status = status;
        this.location_id = location_id;
    }

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
    
    public Category getCategory() {
        return category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setCategory(Category category) {
        this.category = category;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    
    
    
    
    
    
}
