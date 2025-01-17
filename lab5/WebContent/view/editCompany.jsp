<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="by.vsu.company.*"%>
<%@page import="by.vsu.user.*"%>
<%@page import="by.vsu.dbGeneral.*"%>
<%
	Company object = (Company)request.getAttribute("object");
	HttpSession ses = request.getSession();
	User obj = (User)ses.getAttribute("user");	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lab 5</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <style>
       * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .btn {
            height: fit-content;
            display: block;
            padding: 10px 10px;
            text-align: center;
            background-color: #000;
            text-decoration: none;
            color: #fff;
            border: none;
        }
        .btn:hover {
            background-color: #fdd32a;
        }
        h1 {
            color: #000;
        }
        .header {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            height: 8vh;
            background-color: #000;
            align-items: center;
        }
        .nav, .auth {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start;
            align-items: center;
        }
        .nav__item, .auth a {
            margin-right: 15px;
            padding: 10px;
        }
        .company__form {
            margin: 0 auto;
        }
        .form__input {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        input, select {
            width: 300px;
            padding: 11px 0;
            border: none;
            background-color: #eee;
            padding-left: 20px;
            padding-right: 20px;
            border-radius: 3px;
        }

        .company {
            margin: 0 auto;
            width: 50%;
            padding-top: 26px;
        }

        .company h2 {
            font-size: 25px;
        }

        .company .form__input {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1 class="logo">Lab 5</h1>
        <nav class="nav">
        	<c:if test="<%= obj != null && obj.getRole_id() == 1%>">
			    <a href="/lab5/ListUsersServlet" class="nav__item btn">users</a>
			</c:if>
            <a href="/lab5/index.html" class="nav__item btn">company</a>
            <a href="/lab5/ListProjectServlet" class="nav__item btn">project</a>
        </nav>
        <div class="auth">
			<c:if test="<%= obj == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= obj != null %>">
			    <h2 class="login"><%= obj.getLogin() %></h2>
			    <a href="/lab5/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="company">
        <h3 class="company__header">Companies</h3>
        <form class="company__form" action="/lab5/SaveCompanyServlet" method="POST">
        	<div class="form__input" style="display: none">
                <label for="id">
                    Id:
                </label>
                <div class="input">
                    <input id="id" type="text" name="id" value="<%= object != null ? object.getId() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="cname">
                    Название компании:
                </label>
                <div class="input">
                    <input id="cname" type="text" name="cname"  placeholder="Введите название" value="<%= object != null ? object.getCname() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="address">
                    Адрес компании:
                </label>
                <div class="input">
                    <input id="address" type="text" name="address" placeholder="Введите адрес" value="<%= object != null ? object.getAddress() : "" %>">   
                </div>
            </div>
           
            <div class="company">
	            <BUTTON class="btn" type="submit">Сохранить</BUTTON>
	        </div>
        </form>
    </section>
</body>
</html>