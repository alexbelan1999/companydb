<%@page isErrorPage="true"
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%-- атрибут isErrorPage показывает, что данная JSP-страница
        может обрабатывать различные ошибки, в том числе и
        исключительные ситуации --%>

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
<c:choose>
    <c:when test="${not empty pageContext.exception}">
        <%-- проверяем, было ли какое-либо исключение --%>
        <H2>Ошибка работы с базой данных</H2>
        <P>Обратитесь к системному администратору</P>
    </c:when>
    <c:otherwise>
        <H2>Непредвиденная ошибка приложения</H2>
        <P>Обратитесь к системному администратору</P>
    </c:otherwise>
</c:choose>
</BODY>
</HTML>