<%-- 
    Document   : updateStaff
    Created on : Feb 18, 2022, 7:57:37 AM
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
        <%
            ResultSet rsStaffs = (ResultSet) request.getAttribute("rsStaffs");
            ResultSet rsStores = (ResultSet) request.getAttribute("rsStores");
            ResultSet rsManagerWithStaffID = (ResultSet) request.getAttribute("rsManagerWithStaffID");
            ResultSet rsManager = (ResultSet) request.getAttribute("rsManager");
            ResultSet rsStoreName = (ResultSet) request.getAttribute("rsStoreName");

        %>
        <% if (rsStaffs.next()) {%>
        <form action="StaffsController" method="post">
            <p><input type="hidden" name="staffs" value="updateStaff"></p>
            <h3>FORM UPDATE STAFF INFORMATIONS</h3>
            <table>
                <tr>
                    <td><label for="id">StaffID</label></td>
                    <td><input readonly  type="text" name="id" id="id"
                               value="<%=rsStaffs.getInt(1)%>"
                               ></td>
                </tr>
                <tr>
                    <td><label for="fName">firstName</label></td>
                    <td><input  type="text" name="fName" id="fName"
                                value="<%=rsStaffs.getString(2)%>"
                                ></td>
                </tr>
                <tr>
                    <td><label for="lName">lastName</label></td>
                    <td><input  type="text" name="lName" id="lName"
                                value="<%=rsStaffs.getString(3)%>"
                                ></td>
                </tr>
                <tr>
                    <td><label for="email">email</label></td>
                    <td><input  type="text" name="email" id="email"
                                value="<%=rsStaffs.getString(4)%>"
                                ></td>
                </tr>
                <tr>
                    <td><label for="phone">phone</label></td>
                    <td><input  type="text" name="phone" id="phone"
                                value="<%=rsStaffs.getString(5)%>"
                                ></td>
                </tr>
                <tr>
                    <td> Active </td>
                    <td>   <input type="radio" name="active" value="1"
                                  <%=(rsStaffs.getInt(6) == 1 ? "Checked" : "")%>
                                  >Active
                        <input type="radio" name="active" value="0"
                               <%=(rsStaffs.getInt(6) == 0 ? "Checked" : "")%>
                               > DeActive
                </tr>
                <tr>
                    <td><label for="Sid">Store ID</label></td>
                    <td><select name="Sid" id="Sid">
                            <%while (rsStores.next()) {%>
                            <option <%=(rsStores.getInt(1) == rsStaffs.getInt(7) ? "selected" : "")%> value="<%=rsStores.getInt(1)%>"> <%=rsStores.getString(2)%> </option>
                            <% }%>

                        </select></td>
                </tr>
                <tr>
                    <td><label for="Mid">ManagerID</label></td>
                    <td><select name="Mid" id="Mid">               
                            <% while (rsManager.next()) { %>
                            <%
                                String first_name1 = rsManager.getString(3);
                                String last_name1 = rsManager.getString(4);
                                String full_name1 = first_name1 + " " + last_name1;%>
                            <option <%=(rsManager.getInt(1) == rsStaffs.getInt(8) ? "selected" : "")%> value="<%=rsManager.getInt(1)%>"><%=full_name1%></option>
                            <%}%>
                        </select></td>

                </tr>
                <tr>
                    <td colspan="2">
                        <input  type="submit" value="submit" name="submit">
                    </td>
                </tr>
            </table>
        </form>
        <%}%>
    </body>
</html>
