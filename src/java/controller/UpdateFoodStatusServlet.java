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

/**
 *
 * @author SHD
 */
public class UpdateFoodStatusServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int foodId = Integer.parseInt(request.getParameter("id"));
        int newStatus = Integer.parseInt(request.getParameter("status"));

        DAO dao = new DAO();
        dao.updateFoodStatus(foodId, newStatus);

        // Redirect back to the restaurant page or list of foods
        response.sendRedirect("list-foods?restaurant_id=" + request.getParameter("restaurant_id"));
    }

}
