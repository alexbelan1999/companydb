<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:choose>
	<c:when test="${not empty customer}">
		<c:set var="title" value="Редактирование менеджера ${customer.name}"/>
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Добавление нового менеджера"/>
		<jsp:useBean id="customer" class="company.Customers"/>
	</c:otherwise>
</c:choose>

<u:html title="${title}">
	<c:url var="saveUrl" value="/customer/save.html"/>
	<form action="${saveUrl}" method="post">
		<c:if test="${not empty customer.id}">
			<input type="hidden" name="id" value="${customer.id}">
		</c:if>
		<label for="surname">Название:</label><br>
		<input id="surname" name="name" value="${customer.name}"><br>
		<label for="name">Адрес:</label><br>
		<input id="name" name="address" value="${customer.address}"><br>
		<label for="patronymic">Всего проектов:</label><br>
		<input id="patronymic" name="total_pnumber" value="${customer.total_pnumber}"><br>
		<label for="patronymic">Законченных проектов:</label><br>
		<input id="patronymic" name="complet_pnumber" value="${customer.complet_pnumber}"><br>
		<button>Сохранить</button>
	</form>
	<c:if test="${not empty manager.id}">
		<c:url var="deleteUrl" value="/customer/delete.html"/>
		<form action="${deleteUrl}" method="post">
			<input type="hidden" name="id" value="${customer.id}">
			<button>Удалить</button>
		</form>
	</c:if>
</u:html>