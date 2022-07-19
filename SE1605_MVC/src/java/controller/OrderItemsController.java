/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrderItems;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOorderitems;

/**
 *
 * @author nanht
 */
@WebServlet(name = "OrderItemsController", urlPatterns = {"/OrderItemsController"})
public class OrderItemsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                String service = request.getParameter("order_items");
        if (service == null) {
            service = "displayAllOrderItems";
        }
        DAOorderitems dao = new DAOorderitems();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          if (service.equals("displayAllOrderItems")) {
              String order_id = request.getParameter("order_id");
                Vector<OrderItems> vector = dao.listAll("select * from order_items where order_id = '"+ order_id + "'");
                String titlepage = "Order items manager";
                String titleTable = "Order items List";
                // pre data for jsp
                request.setAttribute("orderItemsList", vector);
                request.setAttribute("titlePage", titlepage);
                request.setAttribute("titleTable", titleTable);

                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/displayOrderItems.jsp");
                // run
                dispath.forward(request, response);
            }
            
        }
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

    public static void main(String[] args) {
        
    }
}



