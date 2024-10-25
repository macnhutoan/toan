/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Category;
import model.Location;
import model.Restaurant;

/**
 *
 * @author SHD
 */
public class UpdateRestaurantServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String detail = request.getParameter("detail");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        int locationId = Integer.parseInt(request.getParameter("location_id"));

        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setImage(image);
        restaurant.setAddress(address);
        restaurant.setPhone(phone);
        restaurant.setCate_id(categoryId);
        restaurant.setLocation_id(locationId);
        restaurant.setDetail(detail);
        new DAO().updateRestaurant(restaurant);
        response.sendRedirect("list-restaurant");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Restaurant restaurant = new DAO().getRestaurant(id); // Implement this method in RestaurantDAO
        List<Category> categories = new DAO().getAllCategory();
        List<Location> locations = new DAO().getAllLocation();
        
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("categories", categories);
        request.setAttribute("locations", locations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update-restaurant.jsp");
        dispatcher.forward(request, response);
    }

}
