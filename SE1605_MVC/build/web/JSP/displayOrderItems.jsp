<%-- 
    Document   : displayOrderItems
    Created on : Feb 16, 2022, 10:08:25 PM
    Author     : nanht
--%>

<%@page import="java.util.Vector"%>
<%@page import="entity.OrderItems"%>
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
            Vector<OrderItems> vector = (Vector<OrderItems>) request.getAttribute("orderItemsList");
        %>
        <table border="1">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>order_id</th>
                <th>item_id</th>
                <th>product_id</th>
                <th>quantity</th>
                <th>list_price</th>
                <th>discount</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <% for (OrderItems temp : vector) {%>
            <tr>
                <td><%=temp.getOrder_id()%></td>
                <td><%=temp.getItem_id()%></td>
                <td><%=temp.getProduct_id()%></td>
                <td><%=temp.getQuantity()%></td>
                <td><%=temp.getList_price()%></td>
                <td><%=temp.getDiscount()%></td>
                <% double sum = temp.getQuantity() * temp.getList_price(); %>
                <td><%=sum%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
