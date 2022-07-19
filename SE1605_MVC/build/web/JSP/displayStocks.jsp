<%-- 
    Document   : displayStocks
    Created on : Feb 14, 2022, 5:55:12 PM
    Author     : nanht
--%>

<%@page import="java.util.Vector"%>
<%@page import="entity.Stocks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlePage = (String) request.getAttribute("titlePage");%>
        <title><%=titlePage%></title>
    </head>
    <body>
        <%
            Vector<Stocks> vector = (Vector<Stocks>) request.getAttribute("stocksList");
        %>
        <table border="1">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>StoreID</th>
                <th>ProductID</th>
                <th>Quantity</th>
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
            <% for (Stocks temp : vector) {%>
            <tr>
                <td><%=temp.getStore_id()%></td>
                <td><%=temp.getProduct_id()%></td>
                <td><%=temp.getQuantity()%></td>
                <td><a href="StocksController?stocks=updateStock&storeID=<%=temp.getStore_id()%>&productID=<%=temp.getProduct_id()%>">update</a></td>
                <td><a href="StocksController?stocks=deleteStock&stockID=<%=temp.getStore_id()%>&productID=<%=temp.getProduct_id()%>">delete</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
