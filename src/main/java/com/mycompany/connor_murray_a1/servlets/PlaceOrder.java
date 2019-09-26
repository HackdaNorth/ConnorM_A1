package com.mycompany.connor_murray_a1.servlets;

import com.mycompany.connor_murray_a1.model.PizzaOrder;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Conman
 */
public class PlaceOrder extends HttpServlet {

    //comments for methods
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PizzaOrder order = new PizzaOrder();

        String firstname = (String) session.getAttribute("firstname");
        String phoneNumber = (String) session.getAttribute("phoneNumber");

        order.setFirstName(firstname);
        order.setPhoneNumber(phoneNumber);

        String size = request.getParameter("pizzaSize");
        session.setAttribute("size", size);
        order.setSize(size);

        
        String[] toppingsList = request.getParameterValues("toppings");
        for (int i = 0; i < toppingsList.length; i++) {
            session.setAttribute("toppings", toppingsList);
            order.setToppings(toppingsList);
        }

        //Creating our pizza order and setting all attributes.
        //delivery variable.
        String delivery = request.getParameter("delPick");
        if (delivery.equals("delivery")) {
            session.setAttribute("deliveryOrNot", true);
            order.setDelivery(true);
        } else {
            session.setAttribute("deliveryOrNot", false);
            order.setDelivery(false);
        }
        
        //set order attribute for jsp page
        //create request Dispatcher rd to send information to displayOrder.jsp
        RequestDispatcher rd = request.getRequestDispatcher("displayOrder.jsp");
        rd.forward(request, response);
    }

}
