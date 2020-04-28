<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="speciality.*"%>
<%@page import="user.*"%>
<%@page import="dbGeneral.*"%>
<%
	Speciality object = (Speciality)request.getAttribute("object");
	HttpSession ses = request.getSession();
	User obj = (User)ses.getAttribute("user");	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HOSPITAL</title>
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
            padding: 10px 0;
            text-align: center;
            border-radius: 4px;
            background-color: #37f422;
            text-decoration: none;
            color: #2502ef;
            border: none;
        }
        .btn:hover {
            background-color: #fdd32a;
        }
        h1 {
             color: #091144;
        }
        .header {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            height: 10vh;
            background-color: #d1f7af;
            
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
        .speciality__form {
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

        .speciality {
            margin: 0 auto;
            width: 50%;
            padding-top: 26px;
        }

        .speciality h2 {
            font-size: 25px;
        }

        .speciality .form__input {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1 class="logo">HOSPITAL</h1>
        <nav class="nav">
        	<c:if test="<%= obj != null && obj.getRole_id() == 1%>">
			    <a href="/lab/ListUsersServlet" class="nav__item btn">users</a>
			</c:if>
            <a href="/lab/index.html" class="nav__item btn">specialities</a>
            <a href="/lab/ListDoctorServlet" class="nav__item btn">doctors</a>
        </nav>
        <div class="auth">
			<c:if test="<%= obj == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= obj != null %>">
			    <h2 class="login"><%= obj.getLogin() %></h2>
			    <a href="/lab/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="speciality">
        <h3 class="speciality__header">specialities</h3>
        <form class="speciality__form" action="/lab/SaveSpecialityServlet" method="POST">
        	<div class="form__input" style="display: none">
                <label for="id">
                    Id:
                </label>
                <div class="input">
                    <input id="id" type="text" name="id" value="<%= object != null ? object.getId() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="name_of_speciality">
                    Название специальности:
                </label>
                <div class="input">
                    <input id="name_of_speciality" type="text" name="name_of_speciality"  placeholder="Введите название" value="<%= object != null ? object.getName() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="narrow_speciality">
                    Узкая специальность:
                </label>
                <div class="input">
                    <input id="narrow_speciality" type="text" name="narrow_speciality" placeholder="Узкая?" value="<%= object != null ? object.getnarrow_speciality(): "" %>">   
                </div>
            </div>
              <div class="form__input">
                <label for="rate_of_pay">
                    Ставка:
                </label>
                <div class="input">
                    <input id="rate_of_pay" type="text" name="rate_of_pay" placeholder="Введите ставку" value="<%= object != null ? object.getrate_of_pay() : "" %>">   
                </div>
            </div>
             <div class="speciality__save">
	            <BUTTON class="btn" type="submit">Сохранить</BUTTON>
	        </div>
     
        </form>
    </section>
</body>
</html>