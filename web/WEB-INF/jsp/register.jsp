<%--
    Document   : registerr
    Created on : 18 janv. 2018, 21:24:17
    Author     : Mohamed
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Register</title>
        <!-- Bootstrap core CSS-->
        <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="ressources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="ressources/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="ressources/css/style.css">
        <link href="ressources/css/Responsive.css" rel="stylesheet">
    </head>

    <body class="bg-dark">
        <div class="container">
            <div class="magic"></div>
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register an Account</div>
                <div class="card-body">
                    <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post" >
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <form:label path="user_Firstname" >First name</form:label>
                                    <form:input path="user_Firstname" name="user_Firstname" id="user_Firstname"  cssClass="form-control" aria-describedby="nameHelp" placeholder="Enter first name" />
                                </div>
                                <div class="col-md-6">
                                    <form:label path="user_Lastname">Last Name</form:label>
                                    <form:input path="user_Lastname" cssClass="form-control"  name="user_Lastname" id="user_Lastname" aria-describedby="nameHelp" placeholder="Enter last name"/>
                                </div>
                                <div class="col-md-6">
                                    <form:label path="user_Email">Email</form:label>
                                    <form:input path="user_Email" name="user_Email" id="user_Email" cssClass="form-control" type="email" aria-describedby="emailHelp" placeholder="Enter email" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <form:label path="user_Birthdate">Birthdate</form:label>
                                    <form:input path="user_Birthdate" name="user_Birthdate" id="user_Birthdate" type="date" cssClass="form-control" placeholder="Enter birthdate" required="required"/>
                                </div>
                                <div class="col-md-6">
                                    <form:label path="user_Picture">Profile Picture</form:label>
                                    <form:input path="user_Picture" name="user_Picture" cssClass="form-control" id="user_Picture" type="file" accept="image/*"/>
                                </div>
                                <div class="col-md-6">
                                    <form:label path="user_Intro">Small Intro</form:label>
                                    <form:textarea path="user_Intro" name="user_Intro" id="user_Intro" cssClass="form-control" placeholder="Enter a small intro .." />
                                </div>
                                <div class="col-md-6">
                                    <form:label path="user_Number">Phone</form:label>
                                    <form:input path="user_Number" name="user_Number" id="user_Number" cssClass="form-control" placeholder="Enter first name" />
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <form:label path="user_Password">Password</form:label>
                                    <form:password path="user_Password" name="user_Password" id="user_Password" cssClass="form-control" id="exampleInputPassword1" placeholder="Password" />
                                </div>
                                <div class="col-md-6">
                                    <label for="exampleConfirmPassword">Confirm password</label>
                                    <input class="form-control" id="exampleConfirmPassword" type="password" cssClass="form-control" placeholder="Confirm password">
                                </div>
                            </div>
                        </div>
                        <form:button class="btn btn-primary btn-block" id="register" name="register">Register</form:button>
                    </form:form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="login">Login Page</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="ressources/vendor/jquery/jquery.min.js"></script>
        <script src="ressources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="ressources/vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="ressources/js/index.js"></script>
    </body>

</html>
