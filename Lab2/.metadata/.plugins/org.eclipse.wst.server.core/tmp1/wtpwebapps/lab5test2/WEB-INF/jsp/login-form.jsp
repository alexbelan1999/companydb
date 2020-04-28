<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Форма авторизации</TITLE>
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
<H1>Авторизация</H1>
<c:if test="${not empty param['message']}">
    <P style="color: red;">${param['message']}</P>
</c:if>
<FORM action="login-form.html" method="post">
    <P>Имя пользователя:</P>
    <P><INPUT type="text" name="login"></P>
    <P>Пароль:</P>
    <P><INPUT type="password" name="password"></P>
    <P><BUTTON type="submit">Войти</BUTTON></P>
</FORM>
</BODY>
</HTML>