<%-- 
    Document   : updateOrder
    Created on : Feb 21, 2022, 8:11:02 AM
    Author     : nanht
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Order</title>
    </head>
    <body>
        <% ResultSet rsOrderWithID = (ResultSet) request.getAttribute("rsOrderWithID");
            ResultSet rsOrderStatus = (ResultSet) request.getAttribute("rsOrderStatus");%>

        <% if (rsOrderWithID.next()) {%>
        <form action="OrdersController" method="post">
            <p><input type="hidden" name="orders" value="updateOrder"></p>
            <table>
                <tr>
                    <td><label for="order_id">order_id : </label></td>
                    <td><input readonly type="text" id="order_id" name="order_id" value="<%=rsOrderWithID.getInt(1)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="customer_id">customer_id : </label></td>
                    <td><input readonly type="text" id="customer_id" name="customer_id" value="<%=rsOrderWithID.getInt(2)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="order_status">order_status : </label></td>
                    <td> <select id="order_status" name="order_status" >
                            <% while (rsOrderStatus.next()) {%>            
                            <option <%=(rsOrderWithID.getInt(3) == rsOrderStatus.getInt(1) ? "selected" : "")%> value="<%=rsOrderStatus.getInt(1)%>">
                                <%=(rsOrderStatus.getInt(1) == 1 ? "New" : rsOrderStatus.getInt(1) == 2 ? "Wait" : rsOrderStatus.getInt(1) == 3 ? "Process" : rsOrderStatus.getInt(1) == 4 ? "Done" : rsOrderStatus.getInt(1))%></option>
                                <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td><label for="order_date">order_date : </label></td>
                    <td><input readonly type="text" id="order_date" name="order_date" value="<%=rsOrderWithID.getString(4)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="required_date">required_date : </label></td>
                    <td><input readonly type="text" id="required_date" name="required_date" value="<%=rsOrderWithID.getString(5)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="shipped_date">shipped_date : </label></td>
                    <td><input readonly type="text" id="shipped_date" name="shipped_date" value="<%=rsOrderWithID.getString(6)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="store_id">store_id : </label></td>
                    <td><input readonly type="text" id="store_id" name="store_id" value="<%=rsOrderWithID.getInt(7)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="staff_id">staff_id : </label></td>
                    <td><input readonly type="text" id="staff_id" name="staff_id" value="<%=rsOrderWithID.getInt(8)%>"><br></td>
                </tr>

                <tr>
                    <td style="text-align: center;" colspan="2">
                        <input  type="submit" value="Submit" name="submit">
                    </td>
                </tr>
            </table>
        </form>
        <%}%>
    </body>
</html>
