<%-- 
    Document   : adminlogin
    Created on : Mar 3, 2022, 11:06:20 PM
    Author     : nanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <%         String error = "";
            if ((String) request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
        %>
    </head>
    <body>
        <section class="vh-100 " style="background-color: #508bfc;">
            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <form action="AdminController" method="post">       
                                    <input type="hidden" name="admin" value="login">
                                    <h3 class="mb-5">Sign in</h3>

                                    <div class="form-outline mb-5">
                                        <input type="text" id="typeEmailX-2" name="username" class="form-control form-control-lg" placeholder="Admin name" />
                                    </div>

                                    <div class="form-outline mb-5">
                                        <input type="text" id="typePasswordX-2" name="password" class="form-control form-control-lg" placeholder="Password" />
                                    </div>

                                    <div class="text-danger justify-content-center mb-5">
                                        <p class="fs-5"><%=error%></p>
                                    </div>

                                    <button class="btn btn-primary btn-lg btn-block w-100" value="Submit" name="submit" type="submit">Login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
