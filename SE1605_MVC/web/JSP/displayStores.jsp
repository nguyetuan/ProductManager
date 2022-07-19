<%-- 
    Document   : displayStores
    Created on : Feb 14, 2022, 5:54:50 PM
    Author     : nanht
--%>

<%@page import="java.util.Vector"%>
<%@page import="entity.Stores"%>
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
            Vector<Stores> vector = (Vector<Stores>) request.getAttribute("storesList");
        %>
        <table border="1">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>ID</th>
                <th>StoreName</th>
                <th>phone</th>
                <th>email</th>
                <th>street</th>
                <th>city</th>
                <th>state</th>
                <th>zipCode</th>
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
            <% for (Stores temp : vector) {%>
            <tr>
                <td><%=temp.getStore_id()%></td>
                <td><%=temp.getStore_name()%></td>
                <td><%=temp.getPhone()%></td>
                <td><%=temp.getEmail()%></td>
                <td><%=temp.getStreet()%></td>
                <td><%=temp.getCity()%></td>
                <td><%=temp.getState()%></td>
                <td><%=temp.getZip_code()%></td>
                <td><a href="StoresController?stores=updateStore&storeID=<%=temp.getStore_id()%>">update</a></td>
                <td><a href="StoresController?stores=deleteStore&storeID=<%=temp.getStore_id()%>">delete</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
