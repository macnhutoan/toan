/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SHD
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private String image;
    private String phone;
    private int role;
    private String address;
    private String fullname;
    private int status;

    public Account(int id, String username, String password, String image, String phone, int role, String address, String fullname, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.fullname = fullname;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    public Account(String username, String password, String phone, String address, String fullname) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.fullname = fullname;
    }
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Account(int id, String username, String password, String image, String phone, int role, String address, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.fullname = fullname;
    }
    
    

    public Account(int id, String username, String password, String image, String phone, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.phone = phone;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
