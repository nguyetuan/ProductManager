<%-- 
    Document   : updateStore
    Created on : Feb 21, 2022, 8:09:28 AM
    Author     : nanht
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>FORM ADD STORE INFORMATIONS</h3>

        <%             ResultSet rsStore = (ResultSet) request.getAttribute("rsStore");
        %>
        <%if (rsStore.next()) {%>
        <form action="StoresController" method="Post">
            <p><input type="hidden" name="stores" value="updateStore"></p>
            <table>
                <tr>
                    <td><label for="id">StoreID</label></td>
                    <td><input  type="number" name="id" id="id" value="<%=rsStore.getInt(1)%>"></td>
                </tr>
                <tr>
                    <td><label for="sName">StoreName</label></td>
                    <td><input  type="text" name="sName" id="sName" value="<%=rsStore.getString(2)%>"></td>
                </tr>
                <tr>
                    <td><label for="phone">phone</label></td>
                    <td><input  type="text" name="phone" id="phone" value="<%=rsStore.getString(3)%>"></td>
                </tr>
                <tr>
                    <td><label for="email">email</label></td>
                    <td><input  type="text" name="email" id="email" value="<%=rsStore.getString(4)%>"></td>
                </tr>
                <tr>
                    <td><label for="street">street</label></td>
                    <td><input  type="text" name="street" id="street" value="<%=rsStore.getString(5)%>"></td>
                </tr>
                <tr>
                    <td><label for="city">city</label></td>
                    <td><input  type="text" name="city" id="city" value="<%=rsStore.getString(6)%>"></td>
                </tr>
                <tr>
                    <td><label for="state">state</label></td>
                    <td><input  type="text" name="state" id="state" value="<%=rsStore.getString(7)%>"></td>
                </tr>
                <tr>
                    <td><label for="zipCode">zipCode</label></td>
                    <td><input  type="text" name="zipCode" id="zipCode" value="<%=rsStore.getString(8)%>"></td>
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
