<%-- 
    Document   : removeProduct
    Created on : Feb 27, 2022, 8:30:36 PM
    Author     : nanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove product</title>
    </head>
    <body>
        <%
            String remove = request.getParameter("remove");
            if (remove.equals("RemoveAll")) {
                out.print("<h1>Remove All</h1>");
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String key = em.nextElement().toString(); //get key
                    session.removeAttribute(key);

                }
            } else {
                                out.print("<h1>Remove One</h1>");

                String product_id = request.getParameter("product_id");
                session.removeAttribute(product_id);
            }
        %>


        <h1>Remove Sucess!</h1>

        <h2><a href="/SE1605_MVC/Add2CartController">Continue Shopping</h2>
        <h2><a href="/SE1605_MVC/JSP/showCart.jsp">Shopping Cart Detail</h2>


    </body>
</html>
