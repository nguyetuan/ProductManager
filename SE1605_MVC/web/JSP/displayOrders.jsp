<%-- 
    Document   : displayOrders
    Created on : Feb 16, 2022, 8:47:43 AM
    Author     : nanht
--%>

<%@page import="java.util.Vector"%>
<%@page import="entity.Orders"%>
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
            Vector<Orders> vector = (Vector<Orders>) request.getAttribute("displayList");
        %>
        <table border="1" style="width: 100%">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>order_id</th>
                <th>customer_id</th>
                <th>order_status</th>
                <th>order_date</th>
                <th>required_date</th>
                <th>shipped_date</th>
                <th>store_id</th>
                <th>staff_id</th>
                <th>detail</th>
                <th>update</th>
            </tr>
        </thead>
        <tbody>
            <% for (Orders temp : vector) {%>
            <tr>
                <td><%=temp.getOrder_id()%></td>
                <td><%=temp.getCustomer_id()%></td>
                <td><%=temp.getOrder_status()%></td>
                <td><%=temp.getOrder_date()%></td>
                <td><%=temp.getRequired_date()%></td>
                <td><%=temp.getShipped_date()%></td>
                <td><%=temp.getStore_id()%></td>
                <td><%=temp.getStaff_id()%></td>
                <td><a href="OrderItemsController?order_items=displayAllOrderItems&order_id=<%=temp.getOrder_id()%>">detail</a></td>
                <td><a href="OrdersController?orders=updateOrder&order_id=<%=temp.getOrder_id()%>">update</a></td>

            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
