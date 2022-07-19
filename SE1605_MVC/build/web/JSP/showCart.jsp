<%@page import="entity.OrderItems"%>
<%@page import="java.util.Enumeration"%>
<%@page import="model.DAOproducts"%>
<%@page import="model.DAOorders"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Products"%>
<html>
    <body>
        <%
            if (session.getAttribute("username") == null) {
                response.sendRedirect("index.jsp");
                return;
            }
            Enumeration em = (Enumeration) session.getAttributeNames();
        %>
        <h1>Shopping Cart Details</h1>
        <form action="/SE1605_MVC/Add2CartController" method="post">
            <input type="hidden" name="add2cart" value="updateCartQuantity" />
            <table width=50% border="1">

                <tr>
                    <td>Product ID</td>
                    <td>product_name</td>
                    <td>quantity</td>
                    <td>list_price</td>
                    <td>Total</td>
                    <td>Remove</td>
                </tr>

                <%
                    double total = 0.0;
                    while (em.hasMoreElements()) {
                        String id = em.nextElement().toString();
                        if (!id.equals("username")) {

                            OrderItems od = (OrderItems) session.getAttribute(id);
                            total = total + (od.getList_price() * od.getQuantity());
                %>
                <tr>
                    <td><%=od.getProduct_id()%></td>
                    <td><%=od.getProduct_name()%></td>
                    <td><input value="<%=od.getQuantity()%>" name="quantity"></td>
                    <td><%=od.getList_price()%></td>
                    <td><%=(od.getList_price() * od.getQuantity())%></td>
                    <td><a href="/SE1605_MVC/Add2CartController?add2cart=removeProduct&productID=<%=od.getProduct_id()%>">remove</a></td>
                </tr>

                <% }
                }%>
            </table>
            <input type="submit" value="Update">
        </form>

        <h2>total = <%=total%></h2>
        <h2><a href="/SE1605_MVC/JSP/index.jsp">Products List</h2>
        <h2><a  href="/SE1605_MVC/Add2CartController?add2cart=removeAll">Remove All </h2>    


    </body>
</html>