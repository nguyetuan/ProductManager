package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Account;
import entity.Products;
import java.util.Vector;
import model.DAOproducts;
import java.sql.ResultSet;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Index SE1605</title>\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n");
      out.write("              rel=\"stylesheet\"\n");
      out.write("              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        ");
 DAOproducts daoProduct = new DAOproducts();
            ResultSet rsCategory = daoProduct.getCategory();
            Vector<Products> productsList = daoProduct.getProductWithStatus1();
            if (request.getAttribute("productsList") != null) {
                productsList = (Vector<Products>) request.getAttribute("productsList");
            }

            Account account = (Account) session.getAttribute("username");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"container text-center position-relative \">\n");
      out.write("\n");
      out.write("        <div class=\"container border shadow vh-100\">\n");
      out.write("            <div class=\"row \">\n");
      out.write("                <div class=\"col border justify-content-center ");
      out.print((account != null ? " d-none" : ""));
      out.write("\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"/SE1605_MVC/JSP/login.jsp\">Login</a>\n");
      out.write("                </div>\n");
      out.write("                ");
 if (account != null) {
      out.write("\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <div class=\"nav-link py-4 fs-5 text-uppercase\">Welcome : ");
      out.print(account.getUsername());
      out.write(" </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"/SE1605_MVC/LoginController?login=logout\">Logout</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"/SE1605_MVC/Add2CartController?add2cart=checkOut\">Check-Out</a>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <div class=\"col border ");
      out.print((account != null ? " d-none" : ""));
      out.write("\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"register.jsp\">Register</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col border\">\n");
      out.write("                    <a class=\"nav-link py-4 fs-5 text-uppercase\" href=\"/SE1605_MVC/JSP/showCart.jsp\"  onclick=\"");
      out.print((account == null ? "stopShowCart()" : ""));
      out.write("\">Showcart</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col border \">\n");
      out.write("                    <form class=\"d-flex py-3\" action=\"/SE1605_MVC/ProductsController\" method=\"get\">\n");
      out.write("                        <p><input type=\"hidden\" name=\"products\" value=\"searchProducts\"></p>\n");
      out.write("                        <input name=\"nameWantSearch\"\n");
      out.write("                               class=\"form-control me-2 py-2\" type=\"search\" placeholder=\"Search\"\n");
      out.write("                               aria-label=\"Search\">\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-outline-success py-2\"\n");
      out.write("                               onclick=\"searchProduct()\" value=\"Search\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row row-cols-2\">\n");
      out.write("                <div class=\"col col-2 border pt-5 \">\n");
      out.write("                    <div class=\"list-group\" id=\"list-example\">\n");
      out.write("                        ");
while (rsCategory.next()) {
      out.write("\n");
      out.write("                        <a href=\"/SE1605_MVC/ProductsController?products=searchCategory&categoryName=");
      out.print(rsCategory.getString(1));
      out.write("\"\n");
      out.write("                           class=\"list-group-item list-group-item-action fs-5 product-category\">\n");
      out.write("                            ");
      out.print(rsCategory.getString(1));
      out.write("\n");
      out.write("                        </a>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col col-10\">\n");
      out.write("                    <table class=\"table-hover table-bordered table w-100\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Product Name</th>\n");
      out.write("                                <th>Price</th>\n");
      out.write("                                <th>Description</th>\n");
      out.write("                                <th>Add to cart</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Products pro : productsList) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
      out.print(pro.getProduct_name());
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
      out.print(pro.getPrice());
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
      out.print((pro.getStatus() == 1 ? "New Product" : ""));
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td> <a onclick=\"addSuccess()\" href=\"/SE1605_MVC/Add2CartController?add2cart=AddToCart&productID=");
      out.print(pro.getProduct_id());
      out.write("\">Add to cart</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function stopShowCart() {\n");
      out.write("                alert(\"You have to login first!\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function addSuccess() {\n");
      out.write("            ");
if (account != null) {
      out.write("\n");
      out.write("                alert(\"Product add succesfully to cart!\");\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("                alert(\"You have to login first!\");\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
