<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${not empty task}">
        <c:set var="cipher" value="${task.cipher}"/>
        <c:set var="project_name" value="${task.project_name}"/>
        <c:set var="project_description" value="${task.project_description}"/>
        <c:set var="plan_time" value="${task.plan_time}"/>
        <c:set var="actual_time" value="${task.actual_time}"/>
        <c:set var="lag" value="${task.lag}"/>
    </c:when>
    <c:otherwise>
        <c:set var="cipher" value=""/>
        <c:set var="project_name" value=""/>
        <c:set var="project_description" value=""/>
        <c:set var="plan_time" value=""/>
        <c:set var="actual_time" value=""/>
        <c:set var="lag" value=""/>
    </c:otherwise>
</c:choose>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Проекты</TITLE>
    </HEAD>
    <BODY>
        <FORM action="save.html" method="post">

            <c:if test="${not empty task}">
                <INPUT type="hidden" name="id" value="${task.id}">
            </c:if>

            <P>Cipher:</P>

            <INPUT type="text" name="cipher" value="${cipher}">

            <P>Project name:</P>

            <INPUT type="text" name="project_name" value="${project_name}">
            
            <P>Project description:</P>

            <INPUT type="text" name="project_description" value="${project_description}">
            
            <P>Plan time:</P>

            <INPUT type="text" name="plan_time" value="${plan_time}">
            
            <P>Actual time:</P>

            <INPUT type="text" name="actual_time" value="${actual_time}">
            
            <BUTTON type="submit">Сохранить</BUTTON>
            <A href="index.html">Назад</A>
        </FORM>
   </BODY>
</HTML>