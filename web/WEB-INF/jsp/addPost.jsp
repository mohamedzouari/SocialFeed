<%--
    Document   : addPost
    Created on : Jan 19, 2018, 6:37:29 PM
    Author     : Madou
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Adding Post</title>
    </head>
    <body>
        <form:form id="addForm" modelAttribute="post" action="postAddingProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="post_Status">Post Statust</form:label>
                        </td>
                        <td>
                        <form:input path="post_Status" name="post_Status" id="post_Status" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="post_Text">Post Text</form:label>
                        </td>
                        <td>
                        <form:input path="post_Text" name="post_Text" id="post_Text" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="post_Image">Post Picture</form:label>
                        </td>
                        <td>
                        <form:input path="post_Image" name="post_Image" id="post_Image" type="file" accept="image/*"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form:button id="register" name="register" >Add Post</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="welcome">Home</a>
                        </td>
                    </tr>
                </table>
        </form:form>
    </body>
</html>