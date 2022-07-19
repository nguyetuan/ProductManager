<%-- 
    Document   : displayProducts
    Created on : Feb 14, 2022, 5:54:32 PM
    Author     : nanht
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            Vector<Products> vector = null;
            ResultSet rs = null;
        %>
        <title>List Products</title>
    </head>
    <body><%
        vector = (Vector<Products>) request.getAttribute("displayList");
        %>
        <table border="1" style="width: 100%">
            <thead>
            <caption>List Products</caption>
            <tr>
                <th>product_id</th>
                <th>product_name</th>
                <th>model_year</th>
                <th>list_price</th>
                <th>brand_name</th>
                <th>category_name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
            <% for (Products temp : vector) {%>
            <tr>
                <td><%=temp.getProduct_id()%></td>
                <td><%=temp.getProduct_name()%></td>
                <td><%=temp.getModel_year()%></td>
                <td><%=temp.getPrice()%></td>
                <td><%=temp.getBrand_name()%></td>
                <td><%=temp.getCategory_name()%></td>
                <td><a href="ProductsController?products=updateProduct&productID=<%=temp.getProduct_id()%>">update</a></td>
                <td><a href="">delete</a></td>

            </tr>
            <%}%>
        </tbody>
    </table></html>
