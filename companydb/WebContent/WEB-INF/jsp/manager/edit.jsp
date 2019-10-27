<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<c:choose>
	<c:when test="${not empty manager}">
		<c:set var="title" value="Редактирование менеджера ${manager.surname}"/>
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Добавление нового менеджера"/>
		<jsp:useBean id="manager" class="company.Managers"/>
	</c:otherwise>
</c:choose>

<u:html title="${title}">
	<c:url var="saveUrl" value="/manager/save.html"/>
	<form action="${saveUrl}" method="post">
		<c:if test="${not empty manager.id}">
			<input type="hidden" name="id" value="${manager.id}">
		</c:if>
		<label for="surname">Фамилия:</label><br>
		<input id="surname" name="surname" value="${manager.surname}"><br>
		<label for="name">Имя:</label><br>
		<input id="name" name="name" value="${manager.name}"><br>
		<label for="patronymic">Отчество:</label><br>
		<input id="patronymic" name="patronymic" value="${manager.patronymic}"><br>
		<button>Сохранить</button>
	</form>
	<c:if test="${not empty manager.id}">
		<c:url var="deleteUrl" value="/manager/delete.html"/>
		<form action="${deleteUrl}" method="post">
			<input type="hidden" name="id" value="${manager.id}">
			<button>Удалить</button>
		</form>
	</c:if>
</u:html>