<%-- 
    Document   : updateProduct
    Created on : Feb 21, 2022, 8:08:47 AM
    Author     : nanht
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPDATE PRODUCT</title>
    </head>
    <body>
        <h3>FORM UPDATE PRODUCT INFORMATIONS</h3>

        <%            ResultSet rsProduct = (ResultSet) request.getAttribute("rsProduct");%>
        <%if (rsProduct.next()) {%>
        <form action="ProductsController" method="post">
            <p><input type="hidden" name="products" value="updateProduct"></p>

            <table>
                <tr>
                    <td><label for="product_id">product_id : </label></td>
                    <td><input readonly  type="text" id="product_id" name="product_id" value="<%=rsProduct.getInt(1)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="product_name">product_name : </label></td>
                    <td><input  type="text" id="product_name" name="product_name" value="<%=rsProduct.getString(2)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="model_year">model_year : </label></td>
                    <td><input  type="text" id="model_year" name="model_year" value="<%=rsProduct.getInt(3)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="list_price">list_price : </label></td>
                    <td><input  type="text" id="list_price" name="list_price" value="<%=rsProduct.getInt(4)%>"><br></td>
                </tr>
                <tr>
                    <td><label for="brand_name">brand_name : </label></td>
                    <td><input  type="text" id="brand_name" name="brand_name" value="<%=rsProduct.getString(5)%>"><br></td>

                </tr>
                <tr>
                    <td><label for="category_name">category_name : </label></td>
                    <td><input  type="text" id="category_name" name="category_name" value="<%=rsProduct.getString(6)%>"><br></td>
                </tr>

                <tr>
                    <td style="text-align: center;" colspan="2">
                        <input  type="submit" value="submit" name="submit">
                    </td>
                </tr>
            </table>
        </form>
        <%}%>


    </body>
</html>
