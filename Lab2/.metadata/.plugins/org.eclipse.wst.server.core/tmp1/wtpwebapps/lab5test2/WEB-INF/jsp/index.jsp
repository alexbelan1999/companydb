<%@ page import="java.util.Collection" %>
<%@ page import="pckg.User" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

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
        </ul>
    </div>
</nav>

<c:if test="${object.getRole() != 'admin' && not empty user}">
<FORM action="CathedraDelete.html" method="post">
    <TABLE class="striped">
        <TR>
            <c:if test="${object.getRole() != 'user'}"><TH>&nbsp;</TH></c:if>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=name">
                name
                </A>
            </TH>
            <TH>teachers</TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=phone">
                    phone
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=professorRate">
                    professor rate
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=docentRate">
                    docent rate
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=seniorTeacherRate">
                    senior teacher rate
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=teacherRate">
                    teacher rate
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=professorHours">
                    professor hours
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=docentHours">
                    docent hours
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=seniorTeacherHours">
                    senior teacher hours
                </A>
            </TH>
            <TH>
                <A href="/index.html?id=${param['id']}&sort=teacherHours">
                    teacher hours
                </A>
            </TH>
        </TR>

        <c:forEach var="cathedra" items="${cathedra}">

            <TR>
                <c:if test="${object.getRole() != 'user'}">
                <TD>
                    <p>
                        <label>
                            <input name="id" value="${cathedra.getId()}" type="checkbox" />
                            <span></span>
                        </label>
                    </p>
                </TD>
                </c:if>
                <TD>
                    <A href="edit.html?id=${cathedra.getId()}">
                            ${cathedra.getName()}
                    </A>
                </TD>
                <TD>
                    <A href="TeacherIndex.html?id=${cathedra.getId()}">
                            Teachers
                    </A>
                </TD>
                <TD>
                    <A>
                            ${cathedra.getPhone()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getProfessorRate()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getDocentRate()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getSeniorTeacherRate()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getTeacherRate()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getProfessorHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getDocentHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getSeniorTeacherHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${cathedra.getTeacherHours()}
                    </A>
                </TD>
            </TR>

        </c:forEach>

    </TABLE>

        <c:if test="${object.getRole() != 'user'}">
            <P>
                <A href="edit.html?id=${-1}">Добавить</A>
                <BUTTON type="submit">Удалить</BUTTON>
            </P>
        </c:if>
</FORM>
</c:if>

<c:if test="${object.getRole() == 'admin'}">
<FORM action="CathedraDelete.html" method="post">
    <TABLE class="striped">
        <TR>
            <TH>&nbsp;</TH>
            <TH>user</TH>
            <TH>password</TH>
            <TH>role</TH>
        </TR>
        <c:forEach var="users" items="${users}">
            <TR>
                <TD>
                    <p>
                        <label>
                            <input name="login" value="${users.getLogin()}" type="checkbox" />
                            <span></span>
                        </label>
                    </p>
                </TD>
                <TD>
                    <A href="UserEdit.html?login=${users.getLogin()}">
                            ${users.getLogin()}
                    </A>
                </TD>
                <TD>
                        ${users.getPassword()}
                </TD>
                <TD>
                        ${users.getRole()}
                </TD>
            </TR>
        </c:forEach>
    </TABLE>
    <P>
        <A href="UserEdit.html?login=${null}">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
    </P>
</FORM>
</c:if>
</BODY>
</HTML>