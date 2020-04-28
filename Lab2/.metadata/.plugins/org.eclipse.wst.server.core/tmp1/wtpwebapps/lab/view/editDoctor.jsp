<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="doctor.*"%>
<%@page import="speciality.*"%>
<%@page import="user.*"%>
<%@page import="dbGeneral.*"%>
<%
	Doctor object = (Doctor)request.getAttribute("object");
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
        <h3 class="speciality__header">Doctors</h3>
        <form class="speciality__form" action="/lab/SaveDoctorServlet" method="POST">
        	<div class="form__input" style="display: none">
                <label for="id">
                    Id:
                </label>
                <div class="input">
                    <input id="id" type="text" name="id" value="<%= object != null ? object.getId() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="special_id">
                    Специальность:
                </label>
                <div class="input">
                    <select id="special_id" name="special_id">
   						<option <%= object == null ? "selected" : "" %> value=0>Выберите специальночть</option>
   						<%
			                 for(Table item : Specialty.select()) {
			             %>
   							<option <%= object != null && object.getSpecialId() == item.getId() ? "selected" : "" %> value=<%= item.getId() %>><%= item.getTitle()  %></option>
 						<%
			                 }
			             %> 					
  					</select>   
                </div>
            </div>
            <div class="form__input">
                <label for="surname">
                    Фамилия
                </label>
                <div class="input">
                    <input id="surname" type="text" name="surname" placeholder="Введите Фамилию" value="<%= object != null ? object.getSurname() : "" %>">   
                </div>
            </div>
            
            <div class="form__input">
            
                <label for="name">
                    Имя
                </label>
                <div class="input">
                    <input id="name" type="text" name="name" placeholder="Введите Имя"  value="<%= object != null ? object.getName(): "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="patronymic">
                    Отчество
                </label>
                <div class="input">
                    <input id="patronymic" type="text" name="patronymic" placeholder="Введите Отчество"  value="<%= object != null ? object.getPatronymic() : "" %>">   
                </div>
            </div>
           <div class="form__input">
                <label for="birth_date">
                    День Рождения
                </label>
               <div class="input">
                    <input id="birth_date" type="text" name="birth_date" placeholder="Введите дату рождения"  value="<%= object != null ? object.getDateBirth() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="first_work_date">
                    Первый рабочий день
                </label>
                <div class="input">
                    <input id="first_work_date" type="text" name="first_work_date" placeholder="Взяли на работу"  value="<%= object != null ? object.getFirstWorkDate() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="number_of_workplace">
                    Номер участка
                </label>
                <div class="input">
                    <input id="number_of_workplace" type="text" name="number_of_workplace" placeholder="Введите участок"  value="<%= object != null ? object.getCabinetNumber() : "" %>">   
                </div>
            </div>
      
            <div class="speciality__save">
	            <BUTTON class="btn" type="submit">Сохранить</BUTTON>
	        </div>
        </form>
    </section>
</body>
</html>