/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.Orders;
import entity.Products;
import entity.Staffs;
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
import javax.servlet.http.HttpSession;
import model.DAOcustomers;
import model.DAOorders;
import model.DAOproducts;
import model.DAOstaffs;

/**
 *
 * @author nanht
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
            DAOcustomers daoCustomers = new DAOcustomers();
            DAOorders daoOrders = new DAOorders();
            DAOproducts daoProducts = new DAOproducts();
            DAOstaffs daoStaff = new DAOstaffs();
            try (PrintWriter out = response.getWriter()) {

                /* TODO output your page here. You may use following sample code. */
                String service = request.getParameter("admin");
                if (service == null) {
                    service = "displayLoginForm";

                }

                if (service.equals("displayLoginForm")) {
                    if (session.getAttribute("adminName") == null) {
                        dispath(request, response, "JSP/adminlogin.jsp");
                    } else {
                        request.setAttribute("displayService", "");

                        dispath(request, response, "JSP/admin.jsp");
                    }
                }
                if (service.equals("login")) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
                        dispath(request, response, "JSP/adminlogin.jsp");
                    }
                    if (!daoStaff.isExistAdmin(username, password)) {
                        request.setAttribute("error", "username or password is incorrect");
                        dispath(request, response, "JSP/adminlogin.jsp");
                    } else {
                        ResultSet rs = daoStaff.getAdminByUsername(username);
                        Staffs adminName = null;
                        if (rs.next()) {
                            adminName = new Staffs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                                    rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10));
                        }
                        session.setAttribute("adminName", adminName);
                        request.setAttribute("displayService", "");
                        dispath(request, response, "JSP/admin.jsp");
                        return;
                    }
                }
                if (service.equals("displayAllCustomers")) {
                    Vector<Customers> vector = daoCustomers.listAll("select * from customers");
                    // prepare data for jsp
                    request.setAttribute("displayService", service);
                    request.setAttribute("displayList", vector);
                    dispath(request, response, "JSP/admin.jsp");
                    return;
                }

                if (service.equals("displayAllProducts")) {
                    Vector<Products> displayList = daoProducts.listAll("select * from products");
                    request.setAttribute("displayService", service);
                    request.setAttribute("displayList", displayList);
                    dispath(request, response, "JSP/admin.jsp");
                    return;
                }
                if (service.equals("displayAllOrders")) {
                    Vector<Orders> vector = daoOrders.listAllWithCusName();
//                ResultSet rsCountOrder = daoOrders.getData("select count(order_id) from order_items where order_id = 1");

                    // pre data for jsp
                    request.setAttribute("displayService", service);
                    request.setAttribute("displayList", vector);
                    dispath(request, response, "JSP/admin.jsp");
                    return;
                }

                if (service.equals("logout")) {
                    session.invalidate();
                    dispath(request, response, "JSP/adminlogin.jsp");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
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
