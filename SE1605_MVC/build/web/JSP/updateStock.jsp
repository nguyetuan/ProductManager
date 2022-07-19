<%-- 
    Document   : updateStock
    Created on : Feb 21, 2022, 8:09:00 AM
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
        <h3>FORM UPDATE STOCK INFORMATIONS</h3>

        <%             ResultSet rsStock = (ResultSet) request.getAttribute("rsStock");
            ResultSet rsStores = (ResultSet) request.getAttribute("rsStores");
            ResultSet rsStoreWithID = (ResultSet) request.getAttribute("rsStoreWithID");

        %>
        <% if (rsStock.next()) {%>
        <form action="StocksController" method="Post">
            <p><input type="hidden" name="stocks" value="updateStock"></p>

            <table>
                <tr>
                    <td><label for="id">StoreID</label></td>
                    <td><input readonly type="number" name="id" id="id" value="<%=rsStock.getInt(1)%>"></td></td>
                </tr>

                <tr>
                    <td><label for="pid">ProductID</label></td>
                    <td><input readonly type="number" name="pid" id="pid" value="<%=rsStock.getInt(2)%>"></td>
                </tr>

                <tr>
                    <td><label for="quantity">quantity</label></td>
                    <td><input  type="number" name="quantity" id="quantity" value="<%=rsStock.getInt(3)%>"></td>
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
