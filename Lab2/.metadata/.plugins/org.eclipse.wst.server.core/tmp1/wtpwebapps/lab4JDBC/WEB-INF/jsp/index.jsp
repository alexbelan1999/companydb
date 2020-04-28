<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Проекты</TITLE>
        <STYLE>
            TABLE {
                border-collapse: collapse;
            }
            TH, TD {
                border: 1px solid black;
                padding: 5px 30px 5px 10px;
            }
        </STYLE>
    </HEAD>
    <BODY>
        <FORM action="delete.html" method="post">
            <TABLE>
                <TR>
                    <TH>&nbsp;</TH>
                    <TH>Cipher</TH>
                    <TH>Project name</TH>
                    <TH>Project description</TH>
                    <TH>Plan time</TH>
                    <TH>Actual time</TH>
                    <TH>Lag</TH>
                </TR>

                <c:forEach var="task" items="${tasks}">

                    <TR>
                        <TD>
                            <INPUT type="checkbox" name="id"

                                   value="${task.id}">

                        </TD>
                        <TD>

                            <A href="edit.html?id=${task.id}">
                                ${task.cipher}

                            </A>
                        </TD>

                        <TD>${task.project_name}</TD>
                        <TD>${task.project_description}</TD>
                        <TD>${task.plan_time}</TD>
                        <TD>${task.actual_time}</TD>
                        <TD>${task.lag}</TD>
                    </TR>

                </c:forEach>

            </TABLE>
            <P>
                <A href="edit.html">Добавить</A>
                <BUTTON type="submit">Удалить</BUTTON>
            </P>
            <table>
            	<TR>
            		<TD>Проекты с наибольшим отставанием:</TD>
            	</TR>
            	<c:forEach var="s" items="${str}">

                    <TR>
                        <TD>${s}</TD>
                    </TR>

                </c:forEach>
            </table>
        </FORM>
    </BODY>
</HTML>