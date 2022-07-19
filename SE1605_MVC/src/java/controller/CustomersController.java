/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Customers;
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

/**
 *
 * @author nanht
 */
@WebServlet(name = "CustomersController", urlPatterns = {"/CustomersController"})
public class CustomersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("customers");
        if (service == null) {
            service = "displayAllCustomers";
        }
        DAOcustomers dao = new DAOcustomers();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertCustomer")) {
                String FirstName = request.getParameter("FirstName");
                String LastName = request.getParameter("LastName");
                String Phone = request.getParameter("Phone");
                String Email = request.getParameter("Email");
                String Street = request.getParameter("Street");
                String City = request.getParameter("City");
                String State = request.getParameter("State");
                String Zip_code = request.getParameter("Zip_code");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                ResultSet rsMaxID = dao.getData("select * from customers where customer_id = (select max(customer_id) from customers)");
                int newId = 0;
                if (rsMaxID.next()) {
                    newId = rsMaxID.getInt(1) + 1;
                }

                if (FirstName == null || FirstName.equals("")) {
                    out.println("FirstName can not empty");
                } else if (LastName == null || LastName.equals("")) {
                    out.println("LastName can not empty");
                } else if (Email == null || Email.equals("")) {
                    out.println("Email can not empty");
                } else if (username == null || username.equals("")) {
                    out.println("username can not empty");
                } else if (password == null || password.equals("")) {
                    out.println("password can not empty");
                } else {
                    dao.addCustomer(new Customers(newId, FirstName, LastName, Phone, Email, Street, City, State, Zip_code, username, password));
                    Account account = new Account(username, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", account);
                    response.sendRedirect("JSP/index.jsp");
                }
            }
            if (service.equals("displayAllCustomers")) {
                Vector<Customers> vector = dao.listAll("select * from customers");
                // prepare data for jsp
                request.setAttribute("displayService", service);
                request.setAttribute("displayList", vector);
                //select jsp to view
                dispath(request, response, "JSP/admin.jsp");
            }
            if (service.equals("searchAdminCustomer")) {
                String nameWantSearch = request.getParameter("nameWantSearch");
                if (nameWantSearch.trim().equals("") || nameWantSearch.trim() == null) {
                    Vector<Customers> vector = dao.listAll("select * from customers");
                    // prepare data for jsp
                    request.setAttribute("displayService", "displayAllCustomers");
                    request.setAttribute("displayList", vector);
                    dispath(request, response, "JSP/admin.jsp");
                } else {
                    Vector<Customers> vector = dao.getCustomerByName(nameWantSearch);
                    request.setAttribute("displayService", "displayAllCustomers");
                    request.setAttribute("displayList", vector);
                    dispath(request, response, "JSP/admin.jsp");
                }
            }
            if (service.equals("updateCustomer")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    //step 1 : get data
                    String customer_id = request.getParameter("customerID");
                    ResultSet rs = dao.getCustomerById(Integer.parseInt(customer_id));
                    request.setAttribute("rs", rs);
                    dispath(request, response, "/JSP/updateCustomer.jsp");

                } else {

                    String ID = request.getParameter("ID");
                    int IDNum = Integer.parseInt(ID);
                    String FirstName = request.getParameter("FirstName");
                    String LastName = request.getParameter("LastName");
                    String Phone = request.getParameter("Phone");
                    String Email = request.getParameter("Email");
                    String Street = request.getParameter("Street");
                    String City = request.getParameter("City");
                    String State = request.getParameter("State");
                    String Zip_code = request.getParameter("Zip_code");
                    int n = dao.updateCustomer(new Customers(IDNum, FirstName, LastName, Phone, Email, Street, City, State, Zip_code));
                    response.sendRedirect("CustomersController");
                }
            }
            if (service.equals("deleteCustomer")) {
                String customerID = request.getParameter("customerID");
                int n = dao.deleteCustomer(Integer.parseInt(customerID));

                if (n == 0) {
                    out.print("can't delete this customer");
                } else {
                    out.print("delete success");

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
