<%-- 
    Document   : admin
    Created on : Mar 3, 2022, 11:23:40 PM
    Author     : nanht
--%>

<%@page import="entity.Staffs"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.Orders"%>
<%@page import="entity.Customers"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% if (session.getAttribute("adminName") == null) {
                response.sendRedirect("SE1605_MVC/AdminController");
                return;
            }
            Staffs adminName = (Staffs) session.getAttribute("adminName");
            String totalOrder = (String) session.getAttribute("totalOrder");
            Vector<Products> vectorProducts = null;
            Vector<Customers> vectorCustomers = null;
            Vector<Orders> vectorOrders = null;

            String displayService = "";
            displayService = (String) request.getAttribute("displayService");
            if (displayService.equals("displayAllProducts")) {
                vectorProducts = (Vector<Products>) request.getAttribute("displayList");
            }
            if (displayService.equals("displayAllCustomers")) {
                vectorCustomers = (Vector<Customers>) request.getAttribute("displayList");
            }
            if (displayService.equals("displayAllOrders")) {
                vectorOrders = (Vector<Orders>) request.getAttribute("displayList");
            }

        %>
        <title>Admin</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
    </head>
    <body class="container-fluid text-center position-relative ">

        <div class="container-fluid border shadow vh-100">
            <div class="row ">
                <% if (session.getAttribute("adminName") != null) {%>
                <div class="col border">
                    <div class="nav-link py-4 fs-5 text-uppercase">Welcome : <%=adminName.getUsername()%> </div>
                </div>
                <%}%>
                <div class="col border">
                    <a class="nav-link py-4 fs-5 text-uppercase" href="AdminController?admin=logout">Logout</a>
                </div>
                <!--                <div class="col border">
                                    <a class="nav-link py-4 fs-5 text-uppercase" href="AdminController?admin=checkOut">Check-Out</a>
                                </div>-->
                <% if (displayService.equals("displayAllCustomers")) {%>
                <div class="col border ">
                    <form class="d-flex py-3" action="CustomersController" method="get">
                        <p><input type="hidden" name="customers" value="searchAdminCustomer"></p>
                        <input name="nameWantSearch"
                               class="form-control me-2 py-2" type="search" placeholder="Search Customers"
                               aria-label="Search">
                        <input type="submit" class="btn btn-outline-success py-2"
                               value="Search">
                    </form>
                </div>
                <%}%>
                <% if (displayService.equals("displayAllProducts")) {%>
                <div class="col border ">
                    <form class="d-flex py-3" action="ProductsController" method="get">
                        <p><input type="hidden" name="products" value="adminSearchProduct"></p>
                        <input name="nameWantSearch"
                               class="form-control me-2 py-2" type="search" placeholder="Search Products"
                               aria-label="Search">
                        <input type="submit" class="btn btn-outline-success py-2"
                               value="Search">
                    </form>
                </div>
                <%}%>
                <% if (displayService.equals("displayAllOrders")) {%>
                <div class="col border ">
                    <form class="d-flex py-3" action="OrdersController" method="get">
                        <p><input type="hidden" name="orders" value="searchBillName"></p>
                        <input name="nameWantSearch"
                               class="form-control me-2 py-2" type="search" placeholder="Search Bill"
                               aria-label="Search">
                        <input type="submit" class="btn btn-outline-success py-2"
                               value="Search">
                    </form>
                </div>
                <%}%>
            </div>
            <div class="row row-cols-2">
                <div class="col col-2 border pt-5 ">
                    <div class="list-group" id="list-example">
                        <a href="AdminController?admin=displayAllCustomers"
                           class="list-group-item list-group-item-action fs-5 py-5">Customer Manager
                        </a>
                        <a href="AdminController?admin=displayAllProducts"
                           class="list-group-item list-group-item-action fs-5 py-5">Product Manager
                        </a>
                        <a href="AdminController?admin=displayAllOrders"
                           class="list-group-item list-group-item-action fs-5 py-5">Bill Manager
                        </a>
                    </div>
                </div>
                <div class="col col-10">
                    <% if (displayService.equals("displayAllProducts")) { %>
                    <table class="table-hover table-bordered table w-100">
                        <thead>
                            <tr>
                                <th>product_id</th>
                                <th>product_name</th>
                                <th>model_year</th>
                                <th>list_price</th>
                                <th>brand_name</th>
                                <th>category_name</th>
                                <th>update</th>
                                <th>delete</th>

                            </tr>
                        </thead>
                        <tbody>
                            <% for (Products temp : vectorProducts) {%>
                            <tr>
                                <td><%=temp.getProduct_id()%></td>
                                <td><%=temp.getProduct_name()%></td>
                                <td><%=temp.getModel_year()%></td>
                                <td><%=temp.getPrice()%></td>
                                <td><%=temp.getBrand_name()%></td>
                                <td><%=temp.getCategory_name()%></td>
                                <td><a href="ProductsController?products=updateProduct&productID=<%=temp.getProduct_id()%>">update</a></td>
                                <td><a href="ProductsController?products=deleteProduct&productID=<%=temp.getProduct_id()%>">delete</a></td>

                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <%}%>
                    <% if (displayService.equals("displayAllCustomers")) { %>
                    <table class="table-hover table-bordered table w-100">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>first_name</th>
                                <th>last_name</th>
                                <th>phone</th>
                                <th>email</th>
                                <th>street</th>
                                <th>city</th>
                                <th>state</th>
                                <th>zip_code</th>
                                <th>update</th>
                                <th>delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Customers temp : vectorCustomers) {%>
                            <tr>
                                <td><%=temp.getCustomer_id()%></td>
                                <td><%=temp.getFirst_name()%></td>
                                <td><%=temp.getLast_name()%></td>
                                <td><%=temp.getPhone()%></td>
                                <td><%=temp.getEmail()%></td>
                                <td><%=temp.getStreet()%></td>
                                <td><%=temp.getCity()%></td>
                                <td><%=temp.getState()%></td>
                                <td><%=temp.getZip_code()%></td>
                                <td><a href="CustomersController?customers=updateCustomer&customerID=<%=temp.getCustomer_id()%>">update</a></td>
                                <td><a href="CustomersController?customers=deleteCustomer&customerID=<%=temp.getCustomer_id()%>">delete</a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <%}%>
                    <% if (displayService.equals("displayAllOrders")) { %>
                    <table class="table-hover table-bordered table w-100">
                        <thead>
                            <tr>
                                <th>order_id</th>
                                <th>customer_name</th>
                                <th>order_date</th>
                                <th>total</th>
                                <th>order_status</th>
                                <th>detail</th>
                                <th>update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Orders temp : vectorOrders) {%>
                            <tr>
                                <td><%=temp.getOrder_id()%></td>
                                <td><%=temp.getCustomer_name()%></td>
                                <td><%=temp.getOrder_date()%></td>
                                <td><%=temp.getTotalPrice()%></td>
                                <td><%=(temp.getOrder_status() == 1 ? "New" : temp.getOrder_status() == 2 ? "Wait" : temp.getOrder_status() == 3 ? "Process" : temp.getOrder_status() == 4 ? "Done" : temp.getOrder_status())%></td>
                                <td><a href="OrderItemsController?order_items=displayAllOrderItems&order_id=<%=temp.getOrder_id()%>">detail bill items</a></td>
                                <td><a href="OrdersController?orders=updateOrder&order_id=<%=temp.getOrder_id()%>">update</a></td>

                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <%}%>

                </div>
            </div>
        </div>
    </body>
</html>
