<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Test PosqtgreSQL</TITLE>
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
    	<P>Результаты тестирования PosqtgreSQL:</P>
    	<TABLE>
        	<TR>
                <TH>Create</TH>
                <TH>Insert</TH>
                <TH>Select1</TH>
                <TH>Update</TH>
                <TH>Select2</TH>
                <TH>Drop</TH>
                <TH>All time</TH>
            </TR>

            <c:forEach var="time" items="${Timeall}">

            	<TR>
					<TD>${time.createtime}</TD>
                    <TD>${time.inserttime}</TD>
                    <TD>${time.select1time}</TD>
                    <TD>${time.updatetime}</TD>
                    <TD>${time.select2time}</TD>
                    <TD>${time.droptime}</TD>
                    <TD>${time.alltime}</TD>
                </TR>

            </c:forEach>

   		</TABLE>
        <A href="index.html">Назад</A>
    </BODY>
</HTML>