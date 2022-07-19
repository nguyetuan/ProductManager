<%-- 
    Document   : displayStaff
    Created on : Feb 14, 2022, 5:45:45 PM
    Author     : nanht
--%>

<%@page import="entity.Staffs"%>
<%@page import="java.util.Vector"%>
<%@page import="model.DAOstaffs"%>
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
            Vector<Staffs> vector = (Vector<Staffs>) request.getAttribute("staffsList");
        %>
        <table border="1">
            <thead>
                <% String titleTable = (String) request.getAttribute("titleTable");%>
            <caption><%=titleTable%></caption>
            <tr>
                <th>staff_id</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>email</th>
                <th>phone</th>
                <th>active</th>
                <th>store_id</th>
                <th>manager_id</th>
                <th>update</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
            <% for (Staffs temp : vector) {%>
            <tr>
                <td><%=temp.getStaff_id()%></td>
                <td><%=temp.getFirst_name()%></td>
                <td><%=temp.getLast_name()%></td>
                <td><%=temp.getEmail()%></td>
                <td><%=temp.getPhone()%></td>
                <td><%=temp.getActive()%></td>
                <td><%=temp.getStore_id()%></td>
                <td><%=temp.getManager_id()%></td>
                <td><a href="StaffsController?staffs=updateStaff&staffID=<%=temp.getStaff_id()%>">update</a></td>
                <td><a href="StaffsController?staffs=deleteStaff&staffID=<%=temp.getStaff_id()%>">delete</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
