<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Список менеджеров">
	<c:choose>
		<c:when test="${not empty managers}">
			<table border="1">
				<tr>
					<th>Фамилия</th>
					<th>Имя</th>
					<th>Отчество</th>
					<td></td>
				</tr>
				<c:forEach var="manager" items="${managers}">
					<c:url var="editUrl" value="/manager/edit.html">
						<c:param name="id" value="${manager.id}"/>
					</c:url>
					<tr>
						<td>${manager.surname}</td>
						<td>${manager.name}</td>
						<td>${manager.patronymic}</td>
						<td><a href="${editUrl}">редактировать</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>Список менеджеров пустой</p>
		</c:otherwise>
	</c:choose>
	<c:url var="editUrl" value="/manager/edit.html"/>
	<p><a href="${editUrl}">Добавить нового менеджера</a></p>
</u:html>