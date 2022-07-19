package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Login</title>\n");
      out.write("        <link rel=\"stylesheet\"\n");
      out.write("              href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n");
      out.write("              rel=\"stylesheet\"\n");
      out.write("              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        ");
         String error = "";
            if ((String) request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
            if (session.getAttribute("adminName") != null) {
                response.sendRedirect("admin.jsp");
            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"vh-100 \" style=\"background-color: #508bfc;\">\n");
      out.write("            <div class=\"container py-5 h-100\">\n");
      out.write("                <div class=\"row justify-content-center align-items-center h-100\">\n");
      out.write("                    <div class=\"col-12 col-md-8 col-lg-6 col-xl-5\">\n");
      out.write("                        <div class=\"card shadow-2-strong\" style=\"border-radius: 1rem;\">\n");
      out.write("                            <div class=\"card-body p-5 text-center\">\n");
      out.write("                                <form action=\"AdminController\" method=\"post\">       \n");
      out.write("                                    <input type=\"hidden\" name=\"admin\" value=\"login\">\n");
      out.write("                                    <h3 class=\"mb-5\">Sign in</h3>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-outline mb-5\">\n");
      out.write("                                        <input type=\"text\" id=\"typeEmailX-2\" name=\"username\" class=\"form-control form-control-lg\" placeholder=\"Username\" />\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-outline mb-5\">\n");
      out.write("                                        <input type=\"text\" id=\"typePasswordX-2\" name=\"password\" class=\"form-control form-control-lg\" placeholder=\"Password\" />\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"text-danger justify-content-center mb-5\">\n");
      out.write("                                        <p class=\"fs-5\">");
      out.print(error);
      out.write("</p>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <button class=\"btn btn-primary btn-lg btn-block w-100\" value=\"Submit\" name=\"submit\" type=\"submit\">Login</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
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
