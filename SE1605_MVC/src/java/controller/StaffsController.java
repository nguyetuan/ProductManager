/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.DAOstaffs;

/**
 *
 * @author Dell
 */
@WebServlet(name = "StaffsController", urlPatterns = {"/StaffsController"})
public class StaffsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("staffs");
        if (service == null) {
            service = "displayAllStaffs";
        }
        try (PrintWriter out = response.getWriter()) {
            DAOstaffs dao = new DAOstaffs();
            if (service.equals("insertStaff")) {
                String id = request.getParameter("id");
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String active = request.getParameter("active");
                String storeID = request.getParameter("Sid");
                String managerID = request.getParameter("Mid");

                if (id == null || id.equals("")) {
                    out.println("Staff id is not empty");
                } else if (fName == null || fName.equals("")) {
                    out.println("first name is not empty");
                } else if (lName == null || lName.equals("")) {
                    out.println("last name is not empty");
                } else if (email == null || email.equals("")) {
                    out.println("email is not empty");
                } else if (active == null || active.equals("")) {
                    out.println("active is not empty");
                } else if (storeID == null || storeID.equals("")) {
                    out.println("storeID is not empty");
                }
                int activeNum = Integer.parseInt(active);
                int idNumber = Integer.parseInt(id);
                int storeIDNumber = Integer.parseInt(storeID);
                int managerIDNumber = Integer.parseInt(managerID);
                int n = dao.addStaff(new Staffs(idNumber, fName, lName, email, phone, activeNum, storeIDNumber, managerIDNumber));
                response.sendRedirect("StaffsController");
            }
            if (service.equals("displayAllStaffs")) {
                Vector<Staffs> vector = dao.listAll("select * from staffs");
                String titlePage = "staffs manager";
                String titleTable = "Staffs list";
                // prepare data for jsp
                request.setAttribute("staffsList", vector);
                request.setAttribute("titlePage", titlePage);
                request.setAttribute("titleTable", titleTable);
                //select jsp to view
                RequestDispatcher dispath
                        = request.getRequestDispatcher("/JSP/displayStaffs.jsp");

                //run
                dispath.forward(request, response);

            }
            if (service.equals("updateStaff")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    //step 1 : get data
                    String staffID = request.getParameter("staffID");
                    ResultSet rs = dao.getData("select * from staffs where staff_id = " + staffID);
                    ResultSet rs1 = dao.getData("select * from stores");
                    ResultSet rsManagerWithStaffID = dao.getData("select s1.staff_id, s1.manager_id, s2.first_name, s2.last_name "
                            + "from staffs s1 inner join staffs s2 \n"
                            + "on s1.manager_id = s2.staff_id \n"
                            + "and s1.staff_id = " + staffID);
                    ResultSet rsManager = dao.getData("select staff_id, manager_id, first_name, last_name from staffs");
                    ResultSet rsStoreName = dao.getData("select s.staff_id, st.store_id, st.store_name  from staffs s inner join stores st \n"
                            + "on s.store_id = st.store_id \n"
                            + "and s.staff_id = " + staffID);
                    request.setAttribute("rsStaffs", rs);
                    request.setAttribute("rsStores", rs1);
                    request.setAttribute("rsManagerWithStaffID", rsManagerWithStaffID);
                    request.setAttribute("rsManager", rsManager);
                    request.setAttribute("rsStoreName", rsStoreName);

                    dispath(request, response, "/JSP/updateStaff.jsp");
                } else {
                    //step 2 : update
                    String id = request.getParameter("id");
                    String fName = request.getParameter("fName");
                    String lName = request.getParameter("lName");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    String active = request.getParameter("active");
                    String storeID = request.getParameter("Sid");
                    String managerID = request.getParameter("Mid");

                    int activeNum = Integer.parseInt(active);
                    int idNumber = Integer.parseInt(id);
                    int storeIDNumber = Integer.parseInt(storeID);
                    int managerIDNumber = Integer.parseInt(managerID);
                    int n = dao.updateStaff(new Staffs(idNumber, fName, lName, email, phone, activeNum, storeIDNumber, managerIDNumber));
                    response.sendRedirect("StaffsController");

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
