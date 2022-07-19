<%-- 
    Document   : updateCustomer
    Created on : Feb 21, 2022, 8:10:38 AM
    Author     : nanht
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
        <% ResultSet rs = (ResultSet) request.getAttribute("rs"); %>
    </head>
    <body>
        <% if(rs.next()){ %>
        <form action="CustomersController" method="post">
            <p><input type="hidden" name="customers" value="updateCustomer"></p>
            <table>
                <tr>
                    <td><label for="ID">ID : </label></td>
                    <td><input readonly type="text" id="ID" name="ID" value="<%=rs.getInt(1)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="FirstName">FirstName : </label></td>
                    <td><input  type="text" id="FirstName" name="FirstName" value="<%=rs.getString(2) %>"><br></td>
                </tr>
                <tr>
                    <td><label for="LastName">LastName : </label></td>
                    <td><input  type="text" id="LastName" name="LastName" value="<%=rs.getString(3)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="Phone">Phone : </label></td>
                    <td><input  type="text" id="Phone" name="Phone" value="<%=rs.getString(4)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="Email">Email : </label></td>
                    <td><input  type="text" id="Email" name="Email" value="<%=rs.getString(5)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="Street">Street : </label></td>
                    <td><input  type="text" id="Street" name="Street" value="<%=rs.getString(6)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="City">City : </label></td>
                    <td><input  type="text" id="City" name="City" value="<%=rs.getString(7)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="State">State : </label></td>
                    <td><input  type="text" id="State" name="State" value="<%=rs.getString(8)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="Zip_code">Zip_code : </label></td>
                    <td><input  type="text" id="Zip_code" name="Zip_code" value="<%=rs.getString(9)%>"><br></td>
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
