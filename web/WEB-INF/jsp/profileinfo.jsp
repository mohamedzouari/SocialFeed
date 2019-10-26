<%--
    Document   : welcomee
    Created on : 18 janv. 2018, 23:18:54
    Author     : Mohamed
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
        <title>Profile Information </title>
        <!-- Bootstrap core CSS-->
        <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="ressources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="ressources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="ressources/css/sb-admin.css" rel="stylesheet">
        <!--card margin-->
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
                        <a class="nav-link" href="welcome">
                            <i class="fa fa-fw fa-dashboard"></i>
                            <span class="nav-link-text">My Profile</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                        <a class="nav-link" href="pending">
                            <i class="fa fa-pencil-square-o"></i>
                            <span class="nav-link-text">Pending Posts</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                        <a class="nav-link" href="published">
                            <i class="fa fa-check-square-o"></i>
                            <span class="nav-link-text">Published Posts</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="information">
                            <i class="fa fa-fw fa-table"></i>
                            <span class="nav-link-text">Information</span>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-envelope"></i>
                            <span class="d-lg-none">Messages
                                <span class="badge badge-pill badge-primary">12 New</span>
                            </span>
                            <span class="indicator text-primary d-none d-lg-block">
                                <i class="fa fa-fw fa-circle"></i>
                            </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">New Messages:</h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>David Miller</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>Jane Smith</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <strong>John Doe</strong>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item small" href="#">View all messages</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-bell"></i>
                            <span class="d-lg-none">Alerts
                                <span class="badge badge-pill badge-warning">6 New</span>
                            </span>
                            <span class="indicator text-warning d-none d-lg-block">
                                <i class="fa fa-fw fa-circle"></i>
                            </span>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">New Alerts:</h6>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-success">
                                    <strong>
                                        <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-danger">
                                    <strong>
                                        <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">
                                <span class="text-success">
                                    <strong>
                                        <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
                                </span>
                                <span class="small float-right text-muted">11:21 AM</span>
                                <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item small" href="#">View all alerts</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <form action="searchUser" method="GET" class="form-inline my-2 my-lg-0 mr-lg-2">
                            <div class="input-group">
                                <input  name="name" class="form-control" type="text" placeholder="Search for...">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
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
                        <a href="#">${user.getUser_Firstname()}</a>
                    </li>
                    <li class="breadcrumb-item active">Information</li>
                </ol>


            </div>
            <!-- /.container-fluid-->
            <div class="row">
                <div class="col-lg-11">
                    <!-- Card Columns Example Social Feed-->
                    <div class="mb-0 mt-4">
                        <i class="fa fa-newspaper-o"></i>  My Information</div>
                    <hr class="mt-2">
                    <div class="">

                        <!-- Example Social Card-->
                        <div class="card mb-3">
                            <div class="card-body">
                                <table border="0" cellspacing="10" cellpadding="10">

                                    <tr>
                                        <td rowspan="4"><div class="frame" style="background-image: url('ressources/img/${user.getUser_Picture()}')"></div></td>
                                        <td><h5 class="card-title mb-1"><c:out value="${user.getUser_Intro()}" /></h5></td>
                                    </tr>


                                    <tr>
                                        <td><h6 class="card-title mb-1">Name: </h6></td>
                                        <td><h6 class="card-title mb-1"><c:out value="${user.getUser_Firstname()}" /> <c:out value="${user.getUser_Lastname()}" /></h6></td>
                                    </tr>

                                    <tr>
                                        <td><h6 class="card-title mb-1">Email: </h6></td>
                                        <td><h6 class="card-title mb-1"><c:out value="${user.getUser_Email()}" /></h6></td>
                                    </tr>

                                    <tr>
                                        <td><h6 class="card-title mb-1">Number: </h6></td>
                                        <td><h6 class="card-title mb-1"><c:out value="${user.getUser_Number()}" /></h6></td>
                                    </tr>

                                    <tr>
                                        <td><h6 class="card-title mb-1">Birthdate: </h6></td>
                                        <td><h6 class="card-title mb-1"><c:out value="${user.getUser_Birthdate()}" /></h6></td>
                                    </tr>
                                    <br>
                                </table>

                                <p class="card-text small"></p>
                            </div>
                            <hr class="my-0">

                            <div class="card-footer small text-muted">  Social Network</div>
                        </div>

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
