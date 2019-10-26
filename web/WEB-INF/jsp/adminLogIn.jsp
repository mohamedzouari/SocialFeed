<%--
    Document   : login
    Created on : 18 janv. 2018, 19:24:55
    Author     : Mohamed
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login</title>
        <!-- Bootstrap core CSS-->
        <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="ressources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="ressources/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="ressources/css/style.css">
        <link rel="stylesheet" href="ressources/newcss.css"/>

    </head>

    <body class="bg-dark">
        <div class="container">
            <div class="magic"></div>
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <form:form id="adminLoginForm" modelAttribute="login" action="adminLoginProcess" method="post">
                        <div class="form-group">
                            <form:label path="email" for="exampleInputEmail1">Email address</form:label>
                            <form:input path="email" cssClass="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email" />
                        </div>
                        <div class="form-group">
                            <form:label path="password" for="exampleInputPassword1">Password</form:label>
                            <form:password path="password" cssClass="form-control" id="exampleInputPassword1"  placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox"> Remember Password</label>
                            </div>
                        </div>
                        <div style="color: red;">  ${message}</div>
                        <form:button id="login" name="login" class="btn btn-primary btn-block">Login</form:button>
                    </form:form>
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