<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@ page import="pckg.Cathedra" %>

<%
    Cathedra object = (Cathedra) request.getAttribute("cathedra");

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
<FORM action="CathedraSave.html" method="post">
    <%
        if(object != null) {
    %>
    <INPUT type="hidden" name="id"
           value="<%= object.getId() %>">
    <%
        }
    %>

    <P>name</P>
    <INPUT type="text" name="name"
           value="<%= object != null
                              ? object.getName()
                              : new String() %>">
    <P>phone</P>
    <INPUT type="text" name="phone"
           value="<%= object != null
                              ? object.getPhone()
                              : new String() %>">
    <P>professor rate:</P>
    <INPUT type="text" name="professorRate"
           value="<%= object != null
                              ? object.getProfessorRate()
                              : new String() %>">
    <P>docent rate</P>
    <INPUT type="text" name="docentRate"
           value="<%= object != null
                              ? object.getDocentRate()
                              : new String() %>">
    <P>senior teacher rate</P>
    <INPUT type="text" name="seniorTeacherRate"
           value="<%= object != null
                              ? object.getSeniorTeacherRate()
                              : new String() %>">
    <P>teacherRate</P>
    <INPUT type="text" name="teacherRate"
           value="<%= object != null
                              ? object.getTeacherRate()
                              : new String() %>">
    <P>professor hours</P>
    <INPUT type="text" name="professorHours"
           value="<%= object != null
                              ? object.getProfessorHours()
                              : new String() %>">
    <P>docent hours</P>
    <INPUT type="text" name="docentHours"
           value="<%= object != null
                              ? object.getDocentHours()
                              : new String() %>">
    <P>senior teacher hours</P>
    <INPUT type="text" name="seniorTeacherHours"
           value="<%= object != null
                              ? object.getSeniorTeacherHours()
                              : new String() %>">
    <P>teacher hours</P>
    <INPUT type="text" name="teacherHours"
           value="<%= object != null
                              ? object.getTeacherHours()
                              : new String() %>">
    <BUTTON type="submit">Сохранить</BUTTON>
    <A href="index.html">Назад</A>
</FORM>
</BODY>
</HTML>