<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="by.vsu.project.*"%>
<%@page import="by.vsu.company.*"%>
<%@page import="by.vsu.user.*"%>
<%@page import="by.vsu.dbGeneral.*"%>
<%
	Project object = (Project)request.getAttribute("object");
	HttpSession ses = request.getSession();
	User obj = (User)ses.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Company</title>
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
            border-radius: 4px;
            background-color: #ffdb4d;
            text-decoration: none;
            color: #000;
            border: none;
        }
        .btn:hover {
            background-color: #fdd32a;
        }
        h1 {
            color: #ffdb4d;
        }
        .header {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            height: 8vh;
            background-color: rgb(79, 30, 128);
            box-shadow: 0px 4px 8px rgba(79, 30, 128,0.95);
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
        .project__form {
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

        .project {
            margin: 0 auto;
            width: 50%;
            padding-top: 26px;
        }

        .project h2 {
            font-size: 25px;
        }

        .project .form__input {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1 class="logo">Customers</h1>
        <nav class="nav">
        	<c:if test="<%= obj != null && obj.getRole_id() == 1%>">
			    <a href="/company/ListUsersServlet" class="nav__item btn">Users</a>
			</c:if>
            <a href="/company/index.html" class="nav__item btn">Customers</a>
            <a href="/company/ListProjectServlet" class="nav__item btn">Projects</a>
        </nav>
        <div class="auth">
			<c:if test="<%= obj == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= obj != null %>">
			    <h2 class="login"><%= obj.getLogin() %></h2>
			    <a href="/company/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="project">
        <h3 class="project__header">Projects</h3>
        <form class="project__form" action="/company/SaveProjectServlet" method="POST">
        	<div class="form__input" style="display: none">
                <label for="id">
                    Id:
                </label>
                <div class="input">
                    <input id="id" type="text" name="id" value="<%= object != null ? object.getId() : "" %>">   
                </div>
            </div>
            <div class="form__input">
                <label for="company_id">
                    Компания
                </label>
                <div class="input">
                    <select id="company_id" name="company_id">
   						<option <%= object == null ? "selected" : "" %> value=0>Выберите компанию</option>
   						<%
			                 for(Company item : Companies.select("id")) {
			             %>
   							<option <%= object != null && object.getCompanyid() == item.getId() ? "selected" : "" %> value=<%= item.getId() %>><%= item.getCname()  %></option>
 						<%
			                 }
			             %> 					
  					</select>   
                </div>
            </div>
            <div class="form__input">
                <label for="pname">
                    Название проекта:
                </label>
                <div class="input">
                    <input id="pname" type="text" name="pname"  placeholder="Введите название" value="<%= object != null ? object.getPname() : "" %>">   
                </div>
            </div>
            
            <div class="form__input">
                <label for="start_date">
                    Дата начала 
                </label>
                <div class="input">
                    <input id="start_date" type="text" name="start_date" placeholder="Введите дату начала"  value="<%= object != null ? object.getStartdate().toString() : "" %>">   
                </div>
            </div>
            
            <div class="form__input">
                <label for="plan_end_date">
                    Планируемая дата окончания 
                </label>
                <div class="input">
                    <input id="plan_end_date" type="text" name="plan_end_date" placeholder="Введите дату окончания"  value="<%= object != null ? object.getPlanenddate().toString() : "" %>">   
                </div>
            </div>
            
            <div class="form__input">
                <label for="end_date">
                    Дата окончания 
                </label>
                <div class="input">
                    <input id="end_date" type="text" name="end_date" placeholder="Введите дату окончания"  value="<%= object != null ? object.getEnddate().toString() : "" %>">   
                </div>
            </div>
            
            <div class="form__input">
                <label for="managers_id">
                    Менеджер
                </label>
                <div class="input">
                    <select id="managers_id" name="managers_id">
   						<option <%= object == null ? "selected" : "" %> value=0>Выберите менеджера</option>
   						<%
			                 for(Table item : Managers.select()) {
			             %>
   							<option <%= object != null && object.getManagerid() == item.getId() ? "selected" : "" %> value=<%= item.getId() %>><%= item.getTitle()  %></option>
 						<%
			                 }
			             %> 					
  					</select>   
                </div>
            </div>
            
            <div class="form__input">
                <label for="success">
                    Успешно
                </label>
                <div class="input">
                    <input id="success" type="checkbox" name="success" <%= object != null && object.getSuccess() ? "checked" : "" %>>   
                </div>
            </div>
            
            <div class="project__save">
	            <BUTTON class="btn" type="submit">Сохранить</BUTTON>
	        </div>
        </form>
    </section>
</body>
</html>