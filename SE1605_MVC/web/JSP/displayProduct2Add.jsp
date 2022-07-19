<%-- 
    Document   : displayProduct2Add
    Created on : Feb 24, 2022, 5:38:25 PM
    Author     : nanht
--%>

<%@page import="entity.Products"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <%
                 String newOrderID = (String) request.getAttribute("newOrderID");
            Vector<Products> vector = (Vector<Products>) request.getAttribute("productsList");
        %>
        <table border="1">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>product_id</th>
                <th>product_name</th>
                <th>model_year</th>
                <th>list_price</th>
                <th>brand_name</th>
                <th>category_name</th>
                <th>add2cart</th>
            </tr>
        </thead>
        <tbody>
            <% for (Products temp : vector) {%>
            <tr>
                <td><%=temp.getProduct_id()%></td>
                <td><%=temp.getProduct_name()%></td>
                <td><%=temp.getModel_year()%></td>
                <td><%=temp.getList_price()%></td>
                <td><%=temp.getBrand_name()%></td>
                <td><%=temp.getCategory_name()%></td>
   
                <td><a href="Add2CartController?add2cart=Add2Cart&productID=<%=temp.getProduct_id()%>">add2cart</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    </body>
</html>
