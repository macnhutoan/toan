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
public class AddFoodServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        int restaurantId = Integer.parseInt(request.getParameter("restaurant_id"));
        request.setAttribute("restaurant_id", restaurantId);
        request.getRequestDispatcher("add-food-form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Account account = (Account) request.getSession().getAttribute("account");
        if (account == null || account.getRole() != 2) {
            response.sendRedirect("login.jsp");
            return;
        }
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");
        int price = Integer.parseInt(request.getParameter("price"));
        int status = Integer.parseInt(request.getParameter("status"));
        int restaurantId = Integer.parseInt(request.getParameter("restaurant_id"));

        Food newFood = new Food(0, name, image, restaurantId, detail, price, status);
        DAO dao = new DAO();
        dao.addFood(newFood);

        response.sendRedirect("list-foods?restaurant_id=" + restaurantId);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
