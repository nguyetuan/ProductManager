/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.OrderItems;
import entity.Orders;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOcustomers;
import model.DAOorderitems;
import model.DAOorders;
import model.DAOproducts;

/**
 *
 * @author nanht
 */
@WebServlet(name = "Add2CartController", urlPatterns = {"/Add2CartController"})
public class Add2CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String service = request.getParameter("add2cart");

        DAOproducts daoProduct = new DAOproducts();
        DAOorderitems daoOrderItem = new DAOorderitems();
        DAOorders daoOrder = new DAOorders();
        String newOrderID = null;
        DAOcustomers daoCustomers = new DAOcustomers();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            if (service == null) {
                dispath(request, response, "JSP/index.jsp");
                return;
            }
            if (service.equals("AddToCart")) {
                String productID = request.getParameter("productID");
                int product_id = Integer.parseInt(productID);
                ResultSet rsWithProductID = daoProduct.getProductByProductId(Integer.toString(product_id));
                String product_name = "";
                Double list_price = 0.0;
                if (rsWithProductID.next()) {
                    product_name = rsWithProductID.getString(2);
                    list_price = rsWithProductID.getDouble(4);
                }

                OrderItems orderItems = (OrderItems) session.getAttribute(productID);
                if (orderItems == null) {
                    orderItems = new OrderItems(product_id, product_name, 1, list_price);
                    session.setAttribute(productID, orderItems);
                } else {
                    orderItems.setQuantity(orderItems.getQuantity() + 1);
                    session.setAttribute(productID, orderItems);
                }
                dispath(request, response, "JSP/index.jsp");

                return;
            }
            if (service.equals("showCart")) {

                dispath(request, response, "/JSP/showCart.jsp");

            }
            if (service.equals("updateCartQuantity")) {
                Enumeration em = (Enumeration) session.getAttributeNames();
                String quantity[] = request.getParameterValues("quantity");
                int i = 0;
                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString();
                    if (!id.equals("username")) {
                        OrderItems od = (OrderItems) session.getAttribute(id);
                        od.setQuantity(Integer.parseInt(quantity[i]));
                        i++;
                    }
                }
                dispath(request, response, "/JSP/showCart.jsp");
            }
            if (service.equals("checkOut")) {
                Enumeration em = (Enumeration) session.getAttributeNames();
                ResultSet rsMaxOrderID = daoOrder.getData("select max(order_id) from orders");
                Account account = (Account) session.getAttribute("username");
                int newOrderId = 0, customerID = 0;
                if (rsMaxOrderID.next()) {
                    newOrderId = rsMaxOrderID.getInt(1) + 1;
                }
                ResultSet rsOfUsername = daoCustomers.getAllCustomerByUsername(account.getUsername());

                if (rsOfUsername.next()) {
                    customerID = rsOfUsername.getInt(1);
                }
                daoOrder.addOrders(new Orders(newOrderId, customerID, 1, "2019-08-21", "2020-01-21", null, 3, 2));
                int count = 0;
                while (em.hasMoreElements()) {

                    String id = em.nextElement().toString();
                    if (!id.equals("username")) {
                        OrderItems od = (OrderItems) session.getAttribute(id);
                        count++;
                        daoOrderItem.addOrderItems(new OrderItems(newOrderId, count, od.getProduct_id(), od.getQuantity(), od.getList_price(), 0.20));
                        session.removeAttribute(id);

                    }
                }
                dispath(request, response, "JSP/index.jsp");
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
