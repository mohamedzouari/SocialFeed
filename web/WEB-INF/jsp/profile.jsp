<%--
    Document   : profile
    Created on : 22 janv. 2018, 19:41:48
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
        <title>${user.getUser_Firstname()} ${user.getUser_Lastname()} </title>
        <!--for post adding-->
        <link href="ressources/css/postSpec.css" rel="stylesheet">
        <!-- Bootstrap core CSS-->
        <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="ressources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="ressources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="ressources/css/sb-admin.css" rel="stylesheet">
        <!--for the right margin-->
        <link href="ressources/css/Responsive.css" rel="stylesheet">
        <!-- Custom styles css file -->
        <link rel="stylesheet" href="ressources/css/PStyle.css">


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
                        <p>${user.getUser_Firstname()} ${user.getUser_Lastname()}</p>
                    </li>
                    <li class="breadcrumb-item active">Profile</li>
                </ol>


            </div>
            <!-- /.container-fluid-->
            <div class="row">
                <div class="col-lg-11">
                    <!-- Information -->
                    <div class="">
                        <div class="card-body">

                            <div class="about-me clearfix" id="about-me">
                                <div class="container">
                                    <div class="row">
                                        <!-- Profile Pic -->
                                        <div class="my-pic center col-sm-4 col-xs-12 wow fadeInUp" data-wow-duration="0.5s" data-wow-offset="200">
                                            <img class="frame" src="ressources/img/${user.getUser_Picture()}" alt="my profile">
                                        </div>
                                        <div class="introduction col-sm-8 col-xs-12 wow fadeInUp" data-wow-duration="0.5s" data-wow-offset="200">
                                            <h2 class="h2">${user.getUser_Firstname()} ${user.getUser_Lastname()}</h2>
                                            <div class="heading-line"></div>
                                            <p class="introduce">Intro: </p>
                                            <p class="intro">${user.getUser_Intro()}.</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="profile col-sm-4 col-xs-12 wow fadeInUp text-center" data-wow-duration="0.5s" data-wow-offset="200">
                                            <h3>personal info</h3>
                                            <div class="heading-line"></div>
                                            <div class="personal-wrapper">
                                                <span><strong>name: </strong>${user.getUser_Firstname()} ${user.getUser_Lastname()}</span>
                                                <span><strong>E-mail: </strong><a href="mailto:personal@website.com">${user.getUser_Email()}</a></span>
                                                <span><strong>phone number: </strong>${user.getUser_Number()}</span>
                                                <span><strong>Birthdate: </strong>${user.getUser_Birthdate()}</span>
                                            </div>
                                        </div>
                                        <div class="why-me col-sm-8 col-xs-12 wow fadeInUp" data-wow-duration="0.5s" data-wow-offset="200">
                                            <!-- Start Accordion -->
                                            <div class="accordion">
                                                <div class="acc-item">
                                                    <div class="acc-title"><i class="fa fa-plus"></i> Who am i?</div>
                                                    <div class="acc-content">Monotonectally iterate B2C solutions for interactive solutions. Uniquely synergize client-based channels vis-a-vis robust meta-services. Uniquely leverage other's multidisciplinary web-readiness after optimal.</div>
                                                </div>
                                                <div class="acc-item">
                                                    <div class="acc-title"><i class="fa fa-plus"></i> What I'm really good at?</div>
                                                    <div class="acc-content">Efficiently formulate cross-unit partnerships whereas an expanded array of infrastructures. Intrinsicly whiteboard extensible markets before just.</div>
                                                </div>
                                                <div class="acc-item">
                                                    <div class="acc-title"><i class="fa fa-plus"></i> How can you contact me?</div>
                                                    <div class="acc-content">Proactively empower cutting-edge web services via virtual methodologies. Assertively foster cross-unit benefits via premier mindshare. Proactively target customized channels and team building catalysts.</div>
                                                </div>
                                                <div class="acc-item">
                                                    <div class="acc-title"><i class="fa fa-plus"></i> What is my hobbies</div>
                                                    <div class="acc-content">Compellingly evisculate standardized metrics with 2.0 value. Professionally impact magnetic technologies without.</div>
                                                </div>
                                            </div> <!-- End Accordion -->
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!-- End About Me Section -->
                            <!--<table border="0" cellpadding="15">
                                <tbody>
                                    <tr>
                                        <td rowspan="4"><div class="frame" style="background-image: url('ressources/img/${user.getUser_Picture()}')"></div></td>
                                        <td colspan="3"><h5 class="card-title mb-1">${user.getUser_Firstname()} ${user.getUser_Lastname()}</h5></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><i>${user.getUser_Intro()}</i></td>
                                    </tr>
                                    <tr>
                                        <td><h6>Number: </h6>${user.getUser_Number()}</td>
                                        <td><h6>Email: </h6>${user.getUser_Email()}</td>
                                        <td><h6>Birthdate: </h6>${user.getUser_Birthdate()}</td>
                                    </tr>
                                </tbody>
                            </table>-->
                            <div class="mb-0 mt-4">
                            </div>
                            <!-- Posts-->


                            <div class="mb-0 mt-4">
                                <i class="fa fa-newspaper-o"></i> Wall</div>
                            <hr class="mt-2">

                            <div class="card mb-3">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="widget-area no-padding blank">
                                            <div class="status-upload">
                                                <form modelAttribute="newPost" action="postAddingProcess?id=${user.getUser_ID()}" method="post" >
                                                    <textarea placeholder="Do you know ${user.getUser_Firstname()}?. Tell us something about him" path="post_Text" name="post_Text" id="post_Text"></textarea>
                                                    <ul>
                                                        <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Audio"><i class="fa fa-music"></i></a></li>
                                                        <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Video"><i class="fa fa-video-camera"></i></a></li>
                                                        <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Sound Record"><i class="fa fa-microphone"></i></a></li>
                                                        <li><a title="" data-toggle="tooltip" data-placement="bottom" data-original-title="Picture"><i class="fa fa-picture-o"></i></a></li>
                                                    </ul>
                                                    <button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button>
                                                </form>
                                            </div><!-- Status Upload  -->
                                        </div><!-- Widget Area -->
                                    </div>
                                </div>
                            </div>

                            <div class="">
                                <div class="card mb-3">
                                    <div class="card-body" align="center">
                                        ${Text}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="${linkTo}">
                                            <button type="submit" class="btn btn-success green">
                                                <i class="fa fa-arrow-right"></i>  ${Butt}
                                            </button>
                                        </a>
                                    </div>
                                </div>
                                <c:forEach items="${posts}" var="post">
                                    <!-- Example Social Card-->
                                    <div class="card mb-3">
                                        <img class="card-img-top img-fluid w-100" src="ressources/img/${post.getPost_Image()}" alt="">
                                        <div class="card-body">
                                            <h5 class="card-title mb-1"><c:out value="${post.getPost_Status()}" /></h5>
                                            <p class="card-text small"><c:out value="${post.getPost_Text()}" />
                                            </p>
                                        </div>
                                        <hr class="my-0">
                                        <div class="card-body py-2 small">
                                            ${post.getPost_Likes()}&nbsp;<a class="mr-3 d-inline-block" href="like?postId=${post.getPost_ID()}&l=${user.getUser_ID()}">
                                                <i class="fa fa-fw fa-thumbs-up"></i>Like</a>
                                            ${post.getPost_Dislikes()}&nbsp;<a class="mr-3 d-inline-block" href="dislike?postId=${post.getPost_ID()}&l=${user.getUser_ID()}">
                                                <i class="fa fa-fw fa-thumbs-down"></i>Dislike</a>
                                            <a class="d-inline-block" href="#">
                                                <i class="fa fa-fw fa-bell"></i>Report</a>
                                        </div>
                                        <div class="card-footer small text-muted">Posted a while ago</div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- /Card Columns-->
                        </div>
                        <!--content-wrapper-->
                        <!--<footer class="sticky-footer">
                        <!--<div class="container">
                          <div class="text-center">
                            <small>Copyright � Your Website 2017</small>
                          </div>
                        </div>-->
                        <!--</footer>-->
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
                                            <span aria-hidden="true">�</span>
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
                        <!-- Including jQuery file -->
                        <script src="ressources/js/jquery-1.12.1.min.js"></script>
                        <!-- NiceScroll plugin -->
                        <script src="ressources/js/jquery.nicescroll.min.js"></script>
                        <script src="ressources/js/plugins.js"></script>
                    </div>
                    </body>

                    </html>
