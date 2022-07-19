<%-- 
    Document   : welcomeCustomer
    Created on : Mar 1, 2022, 5:45:28 PM
    Author     : nanht
--%>

<%@page import="model.DAOorders"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
            String newOrderID = (String) request.getAttribute("newOrderID");
            out.print(newOrderID);
            String customerID = (String) request.getAttribute("customerID");
            int customerIDNum = Integer.parseInt(customerID);
            int newOrderIDNum = Integer.parseInt(newOrderID);
            String stringDateToday = (String) request.getAttribute("stringDateToday");
            Vector<Orders> vectorOrderWithCustomerID = (Vector<Orders>) request.getAttribute("vectorOrderWithCustomerID");
            DAOorders daoOrders = new DAOorders();
            boolean isExist = false;
            Orders order = null;
            for (Orders temp : vectorOrderWithCustomerID) {
                if (temp.getOrder_date().equals(stringDateToday)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist == false) {
                newOrderIDNum++;
                order = new Orders(newOrderIDNum, customerIDNum, 3, stringDateToday, stringDateToday, null, (int) (Math.random() * 8), (int) (Math.random() * 8));
                daoOrders.addOrders(order);
            }
            session.setAttribute("newOrderIDNum", String.valueOf(newOrderIDNum));

        %>
        <h1>welcome to our shop</h1>
        <h2><a href="/SE1605_MVC/Add2CartController">product list</h2>
        <br>
        <h2><a href="/SE1605_MVC/JSP/showCart.jsp">Show Shopping Cart</h2>

    </body>
</html>
