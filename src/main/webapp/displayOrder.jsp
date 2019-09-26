<%-- 
    Document   : displayOrder
    Created on : Sep. 18, 2019, 8:23:58 a.m.
    Author     : Conman
--%>

<%@page import="com.mycompany.connor_murray_a1.model.PizzaOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order: </title>

    </head>
    <body>
        
        <% String firstName = (String) session.getAttribute("firstname"); %>
        <% String phoneNumber = (String) session.getAttribute("phoneNumber"); %>
        <% boolean delivery = (boolean) session.getAttribute("deliveryOrNot");%>
        <% String[] toppingsList = request.getParameterValues("toppings"); %>
        <% String size = (String) session.getAttribute("size"); %>

        <% PizzaOrder order = new PizzaOrder(); %>

        

        <h1> Order for <% out.print(firstName);%> confirmed! </h1>
        <ol value="Customer Information:">
            <li>Name: <%out.print(firstName);%></li>
            <li>Number: <%out.print(phoneNumber);%></li>

        </ol>
        <% String deliveryOutput; %>
        <% if (delivery == true) {
                deliveryOutput = "You're pizza will be delivered within 40 minutes";
            } else {
                deliveryOutput = "Your pizza will be ready for pickup in approx 40 "
                        + "minutes";
            }
        %>
        <% out.print(deliveryOutput); %>


        <ol value="Order information:">
            <li>Size of pizza: <% out.print(size); %></li>
            <li>Toppings Requested: <% for (int i = 0; i < toppingsList.length; i++) {
                out.print(toppingsList[i] + ", ");
            } %></li>
            <li>Total for day: <% out.print(order.getPrice(size, delivery, toppingsList)); %></li>
        </ol>
    </body>

</html>
