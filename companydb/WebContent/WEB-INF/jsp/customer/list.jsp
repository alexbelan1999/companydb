<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Список заказчиков">
	<c:choose>
		<c:when test="${not empty customers}">
			<table border="1">
				<tr>
					<th>Название</th>
					<th>Адрес</th>
					<th>Всего проектов</th>
					<th>Законченных проектов</th>
					<td></td>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<c:url var="editUrl" value="/customer/edit.html">
						<c:param name="id" value="${customer.id}"/>
					</c:url>
					<tr>
						<td>${customer.name}</td>
						<td>${customer.address}</td>
						<td>${customer.total_pnumber}</td>
						<td>${customer.complet_pnumber}</td>
						<td><a href="${editUrl}">редактировать</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>Список заказчиков пустой</p>
		</c:otherwise>
	</c:choose>
	<c:url var="editUrl" value="/customer/edit.html"/>
	<p><a href="${editUrl}">Добавить нового заказчика</a></p>
</u:html>