/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Food;

/**
 *
 * @author SHD
 */
public class UpdateFoodServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        int foodId = Integer.parseInt(request.getParameter("id"));
        int restaurantId = Integer.parseInt(request.getParameter("restaurant_id"));
        
        DAO dao = new DAO();
        Food food = dao.getFoodById(foodId);  // You need to implement this method in the DAO.
        request.setAttribute("food", food);
        request.setAttribute("restaurant_id", restaurantId);
        request.getRequestDispatcher("update-food-form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        int foodId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");
        int price = Integer.parseInt(request.getParameter("price"));
        int status = Integer.parseInt(request.getParameter("status"));

        Food updatedFood = new Food(foodId, name, image, 0, detail, price, status);
        DAO dao = new DAO();
        dao.updateFood(updatedFood);

        response.sendRedirect("list-foods?restaurant_id=" + request.getParameter("restaurant_id"));
    }

}
