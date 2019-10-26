<%--
    Document   : adminManip
    Created on : Jan 23, 2018, 10:49:40 AM
    Author     : Madou
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Admin: All Posts </title>
        <!-- Bootstrap core CSS-->
        <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="ressources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="ressources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="ressources/css/sb-admin.css" rel="stylesheet">
        <link href="ressources/css/Responsive.css" rel="stylesheet">
    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="welcome">Social Network</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
                        <a class="nav-link" href="adminManip">
                            <i class="fa fa-fw fa-dashboard"></i>
                            <span class="nav-link-text">All Posts</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="users">
                            <i class="fa fa-fw fa-table"></i>
                            <span class="nav-link-text">All Users</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="reportedPosts">
                            <i class="fa fa-fw fa-table"></i>
                            <span class="nav-link-text">Reported Posts</span>
                        </a>
                    </li>
                    <!--<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                            <i class="fa fa-fw fa-wrench"></i>
                            <span class="nav-link-text">Settings</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseComponents">
                            <li>
                                <a href="#">Navbar</a>
                            </li>
                        </ul>
                    </li>-->
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
                    </li>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <p>${admin.getAdmin_Name()} </p>
                    </li>
                    <li class="breadcrumb-item active">Admin Space</li>
                </ol>


            </div>
            <!-- /.container-fluid-->
            <div class="row">
                <div class="col-lg-11">
                    <!-- Card Columns Example Social Feed-->
                    <div class="mb-0 mt-4">
                        <i class="fa fa-newspaper-o"></i>  All posts </div>
                    <hr class="mt-2">
                    <div class="">
                        <c:forEach items="${posts}" var="post">
                            <!-- Example Social Card-->
                            <div class="card mb-3">
                                <a href="#">
                                    <img class="card-img-top img-fluid w-100" src="${post.getPost_Image()}" alt="">
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title mb-1"><c:out value="${post.getPost_Status()}" /></h5>
                                    <p class="card-text small"><c:out value="${post.getPost_Text()}" /></p>
                                    <a href="deletePost?id=${post.getPost_ID()}"><button class="btn btn-success"><i class="fa fa-trash"></i> Delete</button></a>
                                </div>
                                <hr class="my-0">

                            </div>
                        </c:forEach>
                    </div>
                    <!-- /Card Columns-->
                </div>
                <!--content-wrapper-->
                <footer class="sticky-footer">
                    <!--<div class="container">
                      <div class="text-center">
                        <small>Copyright © Your Website 2017</small>
                      </div>
                    </div>-->
                </footer>
                <!-- Scroll to Top Button-->
                <a class="scroll-to-top rounded" href="#page-top">
                    <i class="fa fa-angle-up"></i>
                </a>
                <!-- Logout Modal-->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                            <div class="modal-footer">
                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                <a class="btn btn-primary" href="logout">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Bootstrap core JavaScript-->
                <script src="ressources/vendor/jquery/jquery.min.js"></script>
                <script src="ressources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                <!-- Core plugin JavaScript-->
                <script src="ressources/vendor/jquery-easing/jquery.easing.min.js"></script>
                <!-- Page level plugin JavaScript-->
                <script src="ressources/vendor/chart.js/Chart.min.js"></script>
                <script src="ressources/vendor/datatables/jquery.dataTables.js"></script>
                <script src="ressources/vendor/datatables/dataTables.bootstrap4.js"></script>
                <!-- Custom scripts for all pages-->
                <script src="ressources/js/sb-admin.min.js"></script>
                <!-- Custom scripts for this page-->
                <script src="ressources/js/sb-admin-datatables.min.js"></script>
                <script src="ressources/js/sb-admin-charts.min.js"></script>
            </div>
    </body>

</html>
