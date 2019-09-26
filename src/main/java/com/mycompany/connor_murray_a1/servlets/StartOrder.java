/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connor_murray_a1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Conman
 */
public class StartOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            String firstname = request.getParameter("cusName");
            session.setAttribute("firstname", firstname);

            String phoneNumber = request.getParameter("cusPhone");
            session.setAttribute("phoneNumber", phoneNumber);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Place your order</title>");
            out.println("</head>");
            out.println("<body>");
            // Displaying customer's name for visual confirmation
            out.println("<h1>Hi " + firstname + ", Phone: " + phoneNumber + "</h1>");

            //starting form tag for placing their pizza order
            out.println("<form action='PlaceOrder.do' method='post'>");
            //Start requesting information for delivery, toppings, and size of pizza.
            //pickup/delivery
            out.println("<h3>Delivery is  a 2$ fee per pizza</h3>");
            out.println("Pick Up or Delivery? <select name='delPick'>");
            out.println("<option value='delivery'>Delivery</option>");
            out.println("<option value='pickUp'>Pick-Up</option>");
            out.println("</select> <br> <br>");

            //Size of pizza
            out.println("--------------------------------------<br>");
            out.println("<input type='radio' name='pizzaSize' value='small'> Small ($5)");
            out.println("<input type='radio' name='pizzaSize' value='medium'> Medium ($7)");
            out.println("<input type='radio' name='pizzaSize' value='large'> Large ($9)<br><br> ");

            //toppings
            out.println("<h3>Each additional topping is  a 1$ fee</h3>");
            out.println("<input type='checkbox' name='toppings' value='pepperoni'> Pepperoni");
            out.println("<input type='checkbox' name='toppings' value='sausage'> Sausage");
            out.println("<input type='checkbox' name='toppings' value='babySpin'> Baby Spinach");
            out.println("<input type='checkbox' name='toppings' value='pepper'> Pepper <br><br>");
            
            out.println("<input type=\"Submit\" value=\"submit\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 
    }
}
