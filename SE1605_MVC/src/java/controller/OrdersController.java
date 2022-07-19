/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOorders;

@WebServlet(name = "OrdersController", urlPatterns = {"/OrdersController"})
public class OrdersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("orders");
        if (service == null) {
            service = "displayAllOrders";
        }
        DAOorders dao = new DAOorders();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertOrder")) {
                String Order_id = request.getParameter("order_id");
                int Od_idNum = Integer.parseInt(Order_id);
                String customer_id = request.getParameter("customer_id");
                int C_idnum = Integer.parseInt(customer_id);
                String order_status = request.getParameter("order_status");
                int Or_status = Integer.parseInt(order_status);
                String order_date = request.getParameter("order_date");
                String required_date = request.getParameter("required_date");
                String shipped_date = request.getParameter("shipped_date");
                String store_id = request.getParameter("store_id");
                int store_idNum = Integer.parseInt(store_id);
                String staff_id = request.getParameter("staff_id");
                int staff_idNum = Integer.parseInt(staff_id);

                int n = dao.addOrders(new Orders(Od_idNum, C_idnum, Or_status, order_date, required_date, shipped_date, store_idNum, staff_idNum));
                response.sendRedirect("OrdersController");
            }
            if (service.equals("displayAllOrders")) {
                Vector<Orders> vector = dao.listAll("select * from orders");
                // pre data for jsp
                request.setAttribute("displayService", service);
                request.setAttribute("displayList", vector);
                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/admin.jsp");
                // run
                dispath.forward(request, response);
            }
            if (service.equals("searchBillName")) {
                String nameWantSearch = request.getParameter("nameWantSearch");
                Vector<Orders> vector = dao.listAll("select od.*,(cus.first_name + ' ' + cus.last_name) name, sum(odI.list_price) total from orders od \n"
                        + "inner join customers cus on cus.customer_id = od.customer_id and \n"
                        + "(cus.first_name + ' ' + cus.last_name) like '%" + nameWantSearch + "%'\n"
                        + "inner join order_items odI on od.order_id = odI.order_id\n"
                        + "group by od.order_id,od.customer_id,od.order_status,od.order_date,\n"
                        + "od.required_date,od.shipped_date,od.store_id,od.staff_id,cus.first_name,cus.last_name\n"
                        + "order by order_id");
                request.setAttribute("displayService", "displayAllOrders");
                request.setAttribute("displayList", vector);
                dispath(request, response, "JSP/admin.jsp");
            }
            if (service.equals("updateOrder")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String order_id = request.getParameter("order_id");
                    ResultSet rsOrderWithID = dao.getData("select * from orders where order_id = " + order_id);
                    ResultSet rsOrderStatus = dao.getData("select distinct order_status from orders");

                    request.setAttribute("rsOrderWithID", rsOrderWithID);
                    request.setAttribute("rsOrderStatus", rsOrderStatus);

                    dispath(request, response, "/JSP/updateOrder.jsp");

                } else {
                    String Order_id = request.getParameter("order_id");
                    int Od_idNum = Integer.parseInt(Order_id);
                    String customer_id = request.getParameter("customer_id");
                    int C_idnum = Integer.parseInt(customer_id);
                    String order_status = request.getParameter("order_status");
                    int Or_status = Integer.parseInt(order_status);

                    String order_date = request.getParameter("order_date");
                    String required_date = request.getParameter("required_date");
                    String shipped_date = request.getParameter("shipped_date");

                    String store_id = request.getParameter("store_id");
                    int store_idNum = Integer.parseInt(store_id);
                    String staff_id = request.getParameter("staff_id");
                    int staff_idNum = Integer.parseInt(staff_id);

                    int n = dao.updateOrder(new Orders(Od_idNum, C_idnum, Or_status, order_date, required_date, shipped_date, store_idNum, staff_idNum));
                    response.sendRedirect("AdminController?admin=displayAllOrders");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispath(HttpServletRequest request,
            HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        // run
        dispath.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
