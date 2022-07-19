/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Stocks;
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
import model.DAOstocks;

/**
 *
 * @author Dell
 */
@WebServlet(name = "StocksController", urlPatterns = {"/StocksController"})
public class StocksController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("stocks");
        if (service == null) {
            service = "displayAllStocks";
        }
        DAOstocks dao = new DAOstocks();
        try (PrintWriter out = response.getWriter()) {
            if (service.equals("insertStock")) {
                String StoreID = request.getParameter("id");
                String ProductID = request.getParameter("pid");
                String Quantity = request.getParameter("quantity");

                if (StoreID == null || StoreID.equals("")) {
                    out.print("Store ID can not empty");
                } else if (ProductID == null || ProductID.equals("")) {
                    out.print("Product ID can not empty");
                } else if (Quantity == null || Quantity.equals("")) {
                    out.print("Quantity can not empty");
                }

                int sIDNumber = Integer.parseInt(StoreID);
                int pIDNumber = Integer.parseInt(ProductID);
                int QuantityNumber = Integer.parseInt(Quantity);
                dao.addStock(new Stocks(sIDNumber, pIDNumber, QuantityNumber));
                response.sendRedirect("StocksController");

            }
            if (service.equals("displayAllStocks")) {
                Vector<Stocks> vector = dao.listAll("select * from stocks");
                String titlePage = "stocks manager";
                String titleTable = "stocks list";
                // prepare data for jsp
                request.setAttribute("stocksList", vector);
                request.setAttribute("titlePage", titlePage);
                request.setAttribute("titleTable", titleTable);
                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/displayStocks.jsp");

                //run
                dispath.forward(request, response);
            }

            if (service.equals("updateStock")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String storeID = request.getParameter("storeID");
                    String productID = request.getParameter("productID");
                    ResultSet rs1 = dao.getData("select * from stores");
                    ResultSet rsStoreWithID = dao.getData("select * from stores where store_id = " + storeID);
                    ResultSet rs = dao.getData("select * from stocks where product_id = " + productID + "and store_id = " + storeID);

                    request.setAttribute("rsStores", rs1);
                    request.setAttribute("rsStock", rs);
                    request.setAttribute("rsStoreWithID", rsStoreWithID);

                    dispath(request, response, "/JSP/updateStock.jsp");

                } else {
                    String StoreID = request.getParameter("id");
                    String ProductID = request.getParameter("pid");
                    String Quantity = request.getParameter("quantity");

                    if (StoreID == null || StoreID.equals("")) {
                        out.print("Store ID can not empty");
                    } else if (ProductID == null || ProductID.equals("")) {
                        out.print("Product ID can not empty");
                    } else if (Quantity == null || Quantity.equals("")) {
                        out.print("Quantity can not empty");
                    }

                    int sIDNumber = Integer.parseInt(StoreID);
                    int pIDNumber = Integer.parseInt(ProductID);
                    int QuantityNumber = Integer.parseInt(Quantity);
                    dao.updateStock(new Stocks(sIDNumber, pIDNumber, QuantityNumber));
                    response.sendRedirect("StocksController");
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
