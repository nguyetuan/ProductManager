package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import entity.Orders;
import entity.Customers;
import java.util.Vector;
import entity.Products;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
 if (session.getAttribute("adminName") == null) {
                response.sendRedirect("SE1605_MVC/AdminController");
                return;
            }
        ResultSet rsAdmin = (ResultSet) session.getAttribute("adminName");
       String adminName = null;
        if(rsAdmin.next()){
            adminName = rsAdmin.getString(9);
        }
            Vector<Products> vectorProducts = null;
            Vector<Customers> vectorCustomers = null;
            Vector<Orders> vectorOrders = null;

            String service = "";
            service = (String) request.getAttribute("service");
            if (service.equals("displayAllProducts")) {
                vectorProducts = (Vector<Products>) request.getAttribute("displayList");
            }
            if (service.equals("displayAllCustomers")) {
                vectorCustomers = (Vector<Customers>) request.getAttribute("displayList");
            }
            if (service.equals("displayAllOrders")) {
                vectorOrders = (Vector<Orders>) request.getAttribute("displayList");
            }

        
      out.write("\n");
      out.write("        <title>Admin</title>\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n");
      out.write("              rel=\"stylesheet\"\n");
      out.write("              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container-fluid text-center position-relative \">\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid border shadow vh-100\">\n");
      out.write("            <div class=\"row \">\n");
      out.write("                ");
 if( adminName != null ){
      out.write("\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <div class=\"nav-link py-4 fs-5 text-uppercase\">Welcome : ");
      out.print(adminName);
      out.write(" </div>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"AdminController?admin=logout\">Logout</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"AdminController?admin=checkOut\">Check-Out</a>\n");
      out.write("                </div>\n");
      out.write("                ");
 if (service.equals("displayAllCustomers")) {
      out.write("\n");
      out.write("                <div class=\"col border \">\n");
      out.write("                    <form class=\"d-flex py-3\" action=\"CustomersController\" method=\"get\">\n");
      out.write("                        <p><input type=\"hidden\" name=\"products\" value=\"searchProducts\"></p>\n");
      out.write("                        <input name=\"nameWantSearch\"\n");
      out.write("                               class=\"form-control me-2 py-2\" type=\"search\" placeholder=\"Search Customers\"\n");
      out.write("                               aria-label=\"Search\">\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-outline-success py-2\"\n");
      out.write("                               value=\"Search\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
 if (service.equals("displayAllProducts")) {
      out.write("\n");
      out.write("                <div class=\"col border \">\n");
      out.write("                    <form class=\"d-flex py-3\" action=\"ProductsController\" method=\"get\">\n");
      out.write("                        <p><input type=\"hidden\" name=\"products\" value=\"searchProducts\"></p>\n");
      out.write("                        <input name=\"nameWantSearch\"\n");
      out.write("                               class=\"form-control me-2 py-2\" type=\"search\" placeholder=\"Search Products\"\n");
      out.write("                               aria-label=\"Search\">\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-outline-success py-2\"\n");
      out.write("                               value=\"Search\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
 if (service.equals("displayAllOrders")) {
      out.write("\n");
      out.write("                <div class=\"col border \">\n");
      out.write("                    <form class=\"d-flex py-3\" action=\"OrdersController\" method=\"get\">\n");
      out.write("                        <p><input type=\"hidden\" name=\"products\" value=\"searchProducts\"></p>\n");
      out.write("                        <input name=\"nameWantSearch\"\n");
      out.write("                               class=\"form-control me-2 py-2\" type=\"search\" placeholder=\"Search Bill\"\n");
      out.write("                               aria-label=\"Search\">\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-outline-success py-2\"\n");
      out.write("                               value=\"Search\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row row-cols-2\">\n");
      out.write("                <div class=\"col col-2 border pt-5 \">\n");
      out.write("                    <div class=\"list-group\" id=\"list-example\">\n");
      out.write("                        <a href=\"CustomersController\"\n");
      out.write("                           class=\"list-group-item list-group-item-action fs-5\">Customer Manager\n");
      out.write("                        </a>\n");
      out.write("                        <a href=\"ProductsController\"\n");
      out.write("                           class=\"list-group-item list-group-item-action fs-5\">Product Manager\n");
      out.write("                        </a>\n");
      out.write("                        <a href=\"OrdersController\"\n");
      out.write("                           class=\"list-group-item list-group-item-action fs-5\">Bill Manager\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col col-10\">\n");
      out.write("                    ");
 if (service.equals("displayAllProducts")) { 
      out.write("\n");
      out.write("                    <table class=\"table-hover table-bordered table w-100\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>product_id</th>\n");
      out.write("                                <th>product_name</th>\n");
      out.write("                                <th>model_year</th>\n");
      out.write("                                <th>list_price</th>\n");
      out.write("                                <th>brand_name</th>\n");
      out.write("                                <th>category_name</th>\n");
      out.write("                                <th>update</th>\n");
      out.write("                                <th>delete</th>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Products temp : vectorProducts) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(temp.getProduct_id());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getProduct_name());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getModel_year());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getPrice());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getBrand_name());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getCategory_name());
      out.write("</td>\n");
      out.write("                                <td><a href=\"ProductsController?products=updateProduct&productID=");
      out.print(temp.getProduct_id());
      out.write("\">update</a></td>\n");
      out.write("                                <td><a href=\"\">delete</a></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
 if (service.equals("displayAllCustomers")) { 
      out.write("\n");
      out.write("                    <table class=\"table-hover table-bordered table w-100\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>ID</th>\n");
      out.write("                                <th>first_name</th>\n");
      out.write("                                <th>last_name</th>\n");
      out.write("                                <th>phone</th>\n");
      out.write("                                <th>email</th>\n");
      out.write("                                <th>street</th>\n");
      out.write("                                <th>city</th>\n");
      out.write("                                <th>state</th>\n");
      out.write("                                <th>zip_code</th>\n");
      out.write("                                <th>update</th>\n");
      out.write("                                <th>delete</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Customers temp : vectorCustomers) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(temp.getCustomer_id());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getFirst_name());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getLast_name());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getPhone());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getEmail());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getStreet());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getCity());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getState());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getZip_code());
      out.write("</td>\n");
      out.write("                                <td><a href=\"CustomersController?customers=updateCustomer&customerID=");
      out.print(temp.getCustomer_id());
      out.write("\">update</a></td>\n");
      out.write("                                <td><a href=\"CustomersController?customers=deleteCustomer&customerID=");
      out.print(temp.getCustomer_id());
      out.write("\">delete</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
 if (service.equals("displayAllOrders")) { 
      out.write("\n");
      out.write("                    <table class=\"table-hover table-bordered table w-100\">\n");
      out.write("                        <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>order_id</th>\n");
      out.write("                            <th>customer_id</th>\n");
      out.write("                            <th>order_status</th>\n");
      out.write("                            <th>order_date</th>\n");
      out.write("                            <th>required_date</th>\n");
      out.write("                            <th>shipped_date</th>\n");
      out.write("                            <th>store_id</th>\n");
      out.write("                            <th>staff_id</th>\n");
      out.write("                            <th>detail</th>\n");
      out.write("                            <th>update</th>\n");
      out.write("                        </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Orders temp : vectorOrders) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(temp.getOrder_id());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getCustomer_id());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getOrder_status());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getOrder_date());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getRequired_date());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getShipped_date());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getStore_id());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(temp.getStaff_id());
      out.write("</td>\n");
      out.write("                                <td><a href=\"OrderItemsController?order_items=displayAllOrderItems&order_id=");
      out.print(temp.getOrder_id());
      out.write("\">detail</a></td>\n");
      out.write("                                <td><a href=\"OrdersController?orders=updateOrder&order_id=");
      out.print(temp.getOrder_id());
      out.write("\">update</a></td>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
