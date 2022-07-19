<%-- Document : index Created on : Mar 2, 2022, 5:56:52 PM Author : nanht --%>

<%@page import="entity.Account"%>
<%@page import="entity.Products" %>
<%@page import="java.util.Vector" %>
<%@page import="model.DAOproducts" %>
<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index SE1605</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">

        <% DAOproducts daoProduct = new DAOproducts();
            ResultSet rsCategory = daoProduct.getCategory();
            Vector<Products> productsList = daoProduct.getProductWithStatus1();
            if (request.getAttribute("productsList") != null) {
                productsList = (Vector<Products>) request.getAttribute("productsList");
            }

            Account account = (Account) session.getAttribute("username");
        %>
    </head>

    <body class="container text-center position-relative ">

        <div class="container border shadow vh-100">
            <div class="row ">
                <div class="col border justify-content-center <%=(account != null ? " d-none" : "")%>">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="/SE1605_MVC/JSP/login.jsp">Login</a>
                </div>
                <% if (account != null) {%>
                <div class="col border">
                    <div class="nav-link py-4 fs-5 text-uppercase">Welcome : <%=account.getUsername()%> </div>
                </div>
                <div class="col border">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="/SE1605_MVC/LoginController?login=logout">Logout</a>
                </div>
                <div class="col border">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="/SE1605_MVC/Add2CartController?add2cart=checkOut">Check-Out</a>
                </div>
                <%}%>
                <div class="col border <%=(account != null ? " d-none" : "")%>">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="JSP/register.jsp">Register</a>
                </div>
                <div class="col border">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="/SE1605_MVC/JSP/showCart.jsp"  onclick="<%=(account == null ? "stopShowCart()" : "")%>">Showcart</a>
                </div>
                <div class="col border ">
                    <form class="d-flex py-3" action="/SE1605_MVC/ProductsController" method="get">
                        <p><input type="hidden" name="products" value="searchProducts"></p>
                        <input name="nameWantSearch"
                               class="form-control me-2 py-2" type="search" placeholder="Search"
                               aria-label="Search">
                        <input type="submit" class="btn btn-outline-success py-2"
                               onclick="searchProduct()" value="Search">
                    </form>
                </div>
            </div>
            <div class="row row-cols-2">
                <div class="col col-2 border pt-5 ">
                    <div class="list-group" id="list-example">
                        <%while (rsCategory.next()) {%>
                        <a href="/SE1605_MVC/ProductsController?products=searchCategory&categoryName=<%=rsCategory.getString(1)%>"
                           class="list-group-item list-group-item-action fs-5 product-category">
                            <%=rsCategory.getString(1)%>
                        </a>
                        <%}%>
                    </div>
                </div>
                <div class="col col-10">
                    <table class="table-hover table-bordered table w-100">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Add to cart</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Products pro : productsList) {%>
                            <tr>
                                <td>
                                    <%=pro.getProduct_name()%>
                                </td>
                                <td>
                                    <%=pro.getPrice()%>
                                </td>
                                <td>
                                    <%=(pro.getStatus() == 1 ? "New Product" : "")%>
                                </td>
                                <td> <a onclick="addSuccess()" href="/SE1605_MVC/Add2CartController?add2cart=AddToCart&productID=<%=pro.getProduct_id()%>">Add to cart</a></td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>

                </div>

            </div>

        </div>
        <script>

            function stopShowCart() {
                alert("You have to login first!");
            }

            function addSuccess() {
            <%if (account != null) {%>
                alert("Product add succesfully to cart!");
            <%} else {%>
                alert("You have to login first!");

            <%}%>
            }

        </script>

    </body>

</html>