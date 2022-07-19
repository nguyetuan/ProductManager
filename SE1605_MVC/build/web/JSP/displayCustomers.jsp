<%-- 
    Document   : displayCustomers
    Created on : Feb 14, 2022, 5:54:19 PM
    Author     : nanht
--%>

<%@page import="java.util.Vector"%>
<%@page import="entity.Customers"%>
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
            Vector<Customers> vector = (Vector<Customers>) request.getAttribute("displayList");
        %>
        <table border="1" style="width: 100%">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
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
            <% for (Customers temp : vector) {%>
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
</body>
</html>
