/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Products;
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
import model.DAOproducts;

/**
 *
 * @author nanht
 */
@WebServlet(name = "ProductsController", urlPatterns = {"/ProductsController"})
public class ProductsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("products");
        if (service == null) {
            service = "displayAllProducts";
        }
        DAOproducts dao = new DAOproducts();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (service.equals("insertProduct")) {
                String product_id = request.getParameter("product_id");
                int product_idNum = Integer.parseInt(product_id);
                String product_name = request.getParameter("product_name");
                String model_year = request.getParameter("model_year");
                int model_yearNum = Integer.parseInt(model_year);
                String list_price = request.getParameter("list_price");
                int list_priceNum = Integer.parseInt(list_price);
                String brand_name = request.getParameter("brand_name");
                String category_name = request.getParameter("category_name");

                int n = dao.addProducts(new Products(product_idNum, product_name, model_yearNum, list_priceNum, brand_name, category_name));
                response.sendRedirect("ProductsController");
            }
            if (service.equals("displayAllProducts")) {
                Vector<Products> displayList = dao.listAll("select * from products");
                request.setAttribute("displayService", service);
                request.setAttribute("displayList", displayList);
                dispath(request, response, "JSP/admin.jsp");
            }

            if (service.equals("searchCategory")) {
                String categoryName = request.getParameter("categoryName");
                Vector<Products> productsList = dao.getProductWithStatus1AndCategoryName(categoryName);
                request.setAttribute("productsList", productsList);
                dispath(request, response, "JSP/index.jsp");
            }
            if (service.equals("adminSearchProduct")) {
                String nameWantSearch = request.getParameter("nameWantSearch");
                if (nameWantSearch.trim().equals("") || nameWantSearch.trim() == null) {
                    Vector<Products> displayList = dao.listAll("select * from products");
                    request.setAttribute("displayService", "displayAllProducts");
                    request.setAttribute("displayList", displayList);
                    dispath(request, response, "JSP/admin.jsp");
                } else {
                    Vector<Products> displayList = dao.getAdminProductByProductName(nameWantSearch);
                    request.setAttribute("displayService", "displayAllProducts");
                    request.setAttribute("displayList", displayList);
                    dispath(request, response, "JSP/admin.jsp");
                }
            }
            if (service.equals("searchProducts")) {
                String nameWantSearch = request.getParameter("nameWantSearch");
                if (nameWantSearch.trim().equals("") || nameWantSearch.trim() == null) {
                    response.sendRedirect("JSP/index.jsp");
                } else {
                    Vector<Products> productsList = dao.getProductWithStatus1AndProductName(nameWantSearch);
                    request.setAttribute("productsList", productsList);
                    dispath(request, response, "JSP/index.jsp");
                }
            }
            if (service.equals("updateProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String productID = request.getParameter("productID");
                    ResultSet rs = dao.getData("select * from products where product_id = " + productID);

                    request.setAttribute("rsProduct", rs);
                    dispath(request, response, "/JSP/updateProduct.jsp");

                } else {
                    String product_id = request.getParameter("product_id");
                    int product_idNum = Integer.parseInt(product_id);
                    String product_name = request.getParameter("product_name");
                    String model_year = request.getParameter("model_year");
                    int model_yearNum = Integer.parseInt(model_year);
                    String list_price = request.getParameter("list_price");
                    int list_priceNum = Integer.parseInt(list_price);
                    String brand_name = request.getParameter("brand_name");
                    String category_name = request.getParameter("category_name");

                    int n = dao.updateProduct(new Products(product_idNum, product_name, model_yearNum, list_priceNum, brand_name, category_name));
                    response.sendRedirect("ProductsController");
                }
            }
            if (service.equals("deleteProduct")) {
                String productID = request.getParameter("productID");
                int n = dao.deleteProduct(Integer.parseInt(productID));
                if (n == 1) {
                    out.print("delete success");
                } else {
                    out.print("can't delete this product");

                }
            }

            if (service.equals("searchProductByPrice")) {
                String from = request.getParameter("from");
                String to = request.getParameter("to");
                out.print(" <table border=\"1\">\n"
                        + "            <thead>\n"
                        + "            <caption>Search product by price</caption>\n"
                        + "                <tr>\n"
                        + "                    <th>product_id</th>\n"
                        + "                    <th>product_name</th>\n"
                        + "                    <th>model_year</th>\n"
                        + "                    <th>list_price</th>\n"
                        + "                    <th>brand_name</th>\n"
                        + "                    <th>category_name</th>\n"
                        + "                    <th>update</th>\n"
                        + "                    <th>delete</th>\n"
                        + "                </tr>\n"
                        + "            </thead>\n"
                        + "            <tbody>");
                Vector<Products> vector = dao.listAll("select * from products where list_price between '" + from + "' and '" + to + " '");
                for (Products obj : vector) {
                    out.print(" <tr>\n"
                            + "                    <td>" + obj.getProduct_id() + "</td>\n"
                            + "                    <td>" + obj.getProduct_name() + "</td>\n"
                            + "                    <td>" + obj.getModel_year() + "</td>\n"
                            + "                    <td>" + obj.getPrice() + "</td>\n"
                            + "                    <td>" + obj.getBrand_name() + "</td>\n"
                            + "                    <td>" + obj.getCategory_name() + "</td>\n"
                            + "                    <td><a href=\"ProductsController?products=updateProduct&product_id=" + obj.getProduct_id() + "\">update</a></td>\n"
                            + "                    <td></td>\n"
                            + "                </tr>");
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
