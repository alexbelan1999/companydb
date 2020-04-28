<%@ page import="java.util.Collection" %>
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
            <li>
        </ul>
    </div>
</nav>
<FORM action="TeacherDelete.html" method="post">
    <TABLE class="striped">
        <TR>
            <c:if test="${object.getRole() != 'user'}"><TH>&nbsp;</TH></c:if>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=name">
                    name
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=surname">
                    surname
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=patronomyc">
                    patronomyc
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=post">
                    post
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=rate">
                    rate
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=right">
                    right
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=lectionHours">
                    lection hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=practiceHours">
                    practice hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=labsHours">
                    labs hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=consultHours">
                    consult hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=examHours">
                    exam hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=creditHours">
                    credit hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=testHours">
                    test hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=audienceHours">
                    audience hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=nonAudienceHours">
                    non audience hours
                </A>
            </TH>
            <TH>
                <A href="/TeacherIndex.html?id=${param['id']}&sort=totalHours">
                    total hours
                </A>
            </TH>
        </TR>

        <c:forEach var="Teacher" items="${teacher}">

            <TR>
                <c:if test="${object.getRole() != 'user'}">
                    <TD>
                        <p>
                            <label>
                                <input name="id" value="${Teacher.getId()}" type="checkbox" />
                                <span></span>
                            </label>
                        </p>
                    </TD>
                </c:if>
                <TD>
                    <A href="/TeacherEdit.html?id=${Teacher.getId()}">
                            ${Teacher.getName()}
                    </A>
                </TD>
                <TD>
                    <A>
                            ${Teacher.getSurname()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getPatronomyc()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getPost()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getRate()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getRight()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getLectionHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getPracticeHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getLabsHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getConsultHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getExamHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getCreditHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getTestHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getAudienceHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getNonAudienceHours()}
                    </A>
                </TD>

                <TD>
                    <A>
                            ${Teacher.getTotalHours()}
                    </A>
                </TD>
            </TR>



        </c:forEach>

    </TABLE>
    <P>
        <c:if test="${object.getRole() != 'user'}">
        <A href="TeacherEdit.html">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
        </c:if>
    </P>
</FORM>
</BODY>
</HTML>