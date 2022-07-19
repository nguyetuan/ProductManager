/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Stores;
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
import model.DAOstores;

/**
 *
 * @author Dell
 */
@WebServlet(name = "StoresController", urlPatterns = {"/StoresController"})
public class StoresController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("stores");
        if (service == null) {
            service = "displayAllStores";
        }
        DAOstores dao = new DAOstores();
        try (PrintWriter out = response.getWriter()) {
            if (service.equals("insertStore")) {
                String id = request.getParameter("id");
                String sName = request.getParameter("sName");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zipCode = request.getParameter("zipCode");

                if (id == null || id.equals("")) {
                    out.println("id can not empty");
                } else if (sName == null || sName.equals("")) {
                    out.println("Store name can not empty");
                }
                int idNumber = Integer.parseInt(id);
                int n = dao.addStore(new Stores(idNumber, sName, phone, email, street, id, state, zipCode));
                response.sendRedirect("StoresController");
            }
            if (service.equals("displayAllStores")) {
                Vector<Stores> vector = dao.listAll("select * from stores");
                String titlePage = "stores manager";
                String titleTable = "stores list";
                // prepare data for jsp
                request.setAttribute("storesList", vector);
                request.setAttribute("titlePage", titlePage);
                request.setAttribute("titleTable", titleTable);
                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/displayStores.jsp");

                //run
                dispath.forward(request, response);
            }
            if (service.equals("updateStore")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    //step 1 : get data
                    String storeID = request.getParameter("storeID");
                    ResultSet rs = dao.getData("select * from stores where store_id = " + storeID);
                    request.setAttribute("rsStore", rs);
                    dispath(request, response, "/JSP/updateStore.jsp");

                } else {
                    String id = request.getParameter("id");
                    String sName = request.getParameter("sName");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String street = request.getParameter("street");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zipCode = request.getParameter("zipCode");
                    int idNumber = Integer.parseInt(id);
                    int n = dao.updateStore(new Stores(idNumber, sName, phone, email, street, city, state, zipCode));
                    response.sendRedirect("StoresController");
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
