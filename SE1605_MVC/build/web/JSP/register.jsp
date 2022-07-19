<%-- 
    Document   : register
    Created on : Mar 3, 2022, 3:49:53 PM
    Author     : nanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <%
            String error = "";
            if ((String) request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
        %>
    </head>
    <body>

        <section class="vh-100" style="background-color: #508bfc;">
            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-10">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <form action="/SE1605_MVC/CustomersController" method="post">
                                    <input type="hidden" name="customers" value="insertCustomer">

                                    <h3 class="mb-4">Register</h3>
                                    <div class="row">
                                        <div class="form-outline mb-1 col-6 ">
                                            <input type="text" name="FirstName" class="form-control form-control-lg text-center" placeholder="First Name" />
                                        </div>
                                        <div class="form-outline mb-2 col-6">
                                            <input type="text" name="LastName" class="form-control form-control-lg text-center" placeholder="Last Name" />
                                        </div>
                                    </div>
                                    <div class="form-outline mb-2">
                                        <input type="number" name="Phone" class="form-control form-control-lg " placeholder="Phone" />
                                    </div>
                                    <div class="form-outline mb-2">
                                        <input type="email" name="Email" class="form-control form-control-lg " placeholder="Email" />
                                    </div>
                                    <div class="form-outline mb-2">
                                        <input type="text" name="Street" class="form-control form-control-lg " placeholder="Street" />
                                    </div>
                                    <div class="row">
                                        <div class="form-outline mb-2 col-4">
                                            <input type="text" name="City" class="form-control form-control-lg text-center" placeholder="City" />
                                        </div>
                                        <div class="form-outline mb-2 col-4">
                                            <input type="text" name="State" class="form-control form-control-lg text-center" placeholder="State" />
                                        </div>     
                                        <div class="form-outline mb-2 col-4">
                                            <input type="text" name="Zip_code" class="form-control form-control-lg" placeholder="Zip Code" />
                                        </div>
                                    </div>
                              

                                    <div class="form-outline mb-2">
                                        <input type="text" name="username" class="form-control form-control-lg " placeholder="Username" />
                                    </div>

                                    <div class="form-outline mb-2">
                                        <input type="password" id="typePasswordX-2" name="password" class="form-control form-control-lg " placeholder="Password" />
                                    </div>

                                    <div class="text-danger justify-content-center mb-5">
                                        <p class="fs-5"><%=error%></p>
                                    </div>

                                    <button class="btn btn-primary btn-lg btn-block w-100" value="Submit" name="submit" type="submit">Register</button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
</body>
</html>
