<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@ page import="pckg.*" %>
<%@ page import="java.util.Collection" %>

<%
    Teacher object = (Teacher) request.getAttribute("teacher");
    Collection<Cathedra> cathedra = (Collection<Cathedra>) request.getAttribute("cathedra");
    Collection<Teacher> teachers = (Collection<Teacher>) request.getAttribute("teachers");
%>
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
<FORM action="TeacherSave.html" method="post">
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
    <P>surname</P>
    <INPUT type="text" name="surname"
           value="<%= object != null
                              ? object.getSurname()
                              : new String() %>">
    <P>patronomyc</P>
    <INPUT type="text" name="patronomyc"
           value="<%= object != null
                              ? object.getPatronomyc()
                              : new String() %>">
    <P>cathedra</P>
    <select name = "cathedraId">
        <% for(Cathedra c: cathedra){ %>
        <option><%= c.getName()%></option>
        <% } %>
    </select>
    <P>post</P>
    <select name = "post">
        <%  int flag = 0;
        for(Teacher c: teachers){
        String post = "manager";
        if(c.getPost().equals(post)){
            flag = 1;
        }}
        if(flag == 0){%>
        <option>manager</option>
        <% }%>
        <option>professor</option>
        <option>docent</option>
        <option>Senior teacher</option>
        <option>teacher</option>
    </select>
    <BUTTON type="submit">Сохранить</BUTTON>
    <A href="index.html">Назад</A>
</FORM>
</BODY>
</HTML>