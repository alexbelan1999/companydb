<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@ page import="pckg.*" %>

<%
    User object = (User) request.getAttribute("user");

%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Тест JSP</TITLE>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
</HEAD>
<BODY>
<nav>
    <div class="nav-wrapper">
        <a href="index.html" class="brand-logo">Cathedras</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li>
                <c:choose>
                <c:when test="${not empty user}">
                    ${user.login}&nbsp;&mdash; <li><A href="logout.html">Logout</A></li>
            </c:when>
            <c:otherwise>
                <A href="login-form.html">Login</A>
            </c:otherwise>
            </c:choose>
            </li>
            <li>
                <A href="TeacherIndex.html">Teachers</A>
            </li>
        </ul>
    </div>
</nav>
<FORM action="UserSave.html" method="post">

    <P>name</P>
    <INPUT type="text" name="login"
           value="<%= object != null
                              ? object.getLogin()
                              : new String() %>">
    <P>password</P>
    <INPUT type="text" name="password"
           value="<%= object != null
                              ? object.getPassword()
                              : new String() %>">
    <P>role:</P>
    <INPUT type="text" name="role"
           value="<%= object != null
                              ? object.getRole()
                              : new String() %>">

    <BUTTON type="submit">Сохранить</BUTTON>
    <A href="index.html">Назад</A>
</FORM>
</BODY>
</HTML>