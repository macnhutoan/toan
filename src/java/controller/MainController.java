/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

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
public class MainController extends HttpServlet {
   
    //customer
    private static final String homeServlet = "home";
    private static final String loginServlet = "login";
    private static final String logoutServlet = "logout";
    private static final String detailServlet = "detail";
    private static final String foodServlet = "food";
    private static final String detailFoodServlet = "detail-food";
    private static final String register = "register";
    private static final String addReview = "add-review";
    private static final String editReviewRestaurant = "edit-review-restaurant";
    private static final String addReviewRestaurant = "add-review-restaurant";
    private static final String removeReviewRestaurant = "remove-review-restaurant";
    
    //admin
    private static final String addRestaurantAdminServlet = "add-restaurant-admin";
    private static final String editRestaurantAdminServlet = "edit-restaurant-admin";
    private static final String listRestaurantAdminServlet = "list-restaurant-admin";
    private static final String actionRestaurantAdminServlet = "action-restaurant-admin";
    
    private static final String listAccountAdminServlet = "list-account-admin";
    private static final String actionAccountAdminServlet = "action-account-admin";
    private static final String viewAccountAdminServlet = "view-account-admin";
    
    private static final String addFoodAdminServlet = "add-food-admin";
    private static final String editFoodAdminServlet = "edit-food-admin";
    private static final String listFoodAdminServlet = "list-food-admin";
    private static final String actionFoodAdminServlet = "action-food-admin";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action  = request.getParameter("action");
        if(action == null){
            request.getRequestDispatcher(homeServlet).forward(request, response);
        }else{
            switch (action) {
                case "edit-review-restaurant":
                    request.getRequestDispatcher(editReviewRestaurant).forward(request, response);
                    break;
                case "add-review-restaurant":
                    request.getRequestDispatcher(addReviewRestaurant).forward(request, response);
                    break;
                case "remove-review-restaurant":
                    request.getRequestDispatcher(removeReviewRestaurant).forward(request, response);
                    break;
                 case "add-restaurant-admin":
                    request.getRequestDispatcher(addRestaurantAdminServlet).forward(request, response);
                    break;
                 case "edit-restaurant-admin":
                    request.getRequestDispatcher(editRestaurantAdminServlet).forward(request, response);
                    break;
                 case "list-restaurant-admin":
                    request.getRequestDispatcher(listRestaurantAdminServlet).forward(request, response);
                    break;
                 case "action-restaurant-admin":
                    request.getRequestDispatcher(actionRestaurantAdminServlet).forward(request, response);
                    break;
                case "add-food-admin":
                    request.getRequestDispatcher(addFoodAdminServlet).forward(request, response);
                    break;
                 case "edit-food-admin":
                    request.getRequestDispatcher(editFoodAdminServlet).forward(request, response);
                    break;
                 case "list-food-admin":
                    request.getRequestDispatcher(listFoodAdminServlet).forward(request, response);
                    break;
                 case "action-food-admin":
                    request.getRequestDispatcher(actionFoodAdminServlet).forward(request, response);
                    break;
                 case "view-account-admin":
                    request.getRequestDispatcher(viewAccountAdminServlet).forward(request, response);
                    break;
                 case "list-account-admin":
                    request.getRequestDispatcher(listAccountAdminServlet).forward(request, response);
                    break;
                 case "action-account-admin":
                    request.getRequestDispatcher(actionAccountAdminServlet).forward(request, response);
                    break;
                
                    
                case "login":
                    request.getRequestDispatcher(loginServlet).forward(request, response);
                    break;
                case "logout":
                    request.getRequestDispatcher(logoutServlet).forward(request, response);
                    break;
                case "detail":
                    request.getRequestDispatcher(detailServlet).forward(request, response);
                    break;
                 case "home":
                    request.getRequestDispatcher(homeServlet).forward(request, response);
                    break;
                case "food":
                    request.getRequestDispatcher(foodServlet).forward(request, response);
                    break;
                case "detail-food":
                    request.getRequestDispatcher(detailFoodServlet).forward(request, response);
                    break;
                case "register":
                    request.getRequestDispatcher(register).forward(request, response);
                    break;
                case "add-review":
                    request.getRequestDispatcher(addReview).forward(request, response);
                    break;
                
                default:
                    throw new AssertionError();
            }
          
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
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
