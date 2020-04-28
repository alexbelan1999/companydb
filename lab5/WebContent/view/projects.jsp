<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="by.vsu.user.*"%>
<%@page import="by.vsu.project.*"%>
<%@page import="by.vsu.company.*"%>
<%@page import="by.vsu.dbGeneral.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
	HttpSession ses = request.getSession();
	User object = (User)ses.getAttribute("user");
	@SuppressWarnings("unchecked")
    ArrayList<Project> projects = (ArrayList<Project>)request.getAttribute("objects");
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
         h2 {
            color: #fff;
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
        .projects__header {
            padding: 15px;
            font-size: 25px;
        }

        .projects__table {
            width: 99%;
            margin: 15px auto;
            border: 1px solid #eee;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #eee;
            padding: 10px;
        }

        .edit i:hover {
            color: green;
            cursor: pointer;
        }

        .del i:hover {
            color: #ed1414;
            cursor: pointer;
        }
        
        .edit i, .del i {
        	color: #000;
        }

        .edit, .del {
            text-align: center;
        }

    </style>
</head>
<body>
    <header class="header">
        <h1 class="logo">Lab 5</h1>
        <nav class="nav">
        	<c:if test="<%= object != null && object.getRole_id() == 1%>">
			    <a href="/lab5/ListUsersServlet" class="nav__item btn">users</a>
			</c:if>
            <a href="/lab5/index.html" class="nav__item btn">company</a>
            <a href="/lab5/ListProjectServlet" class="nav__item btn">project</a>
        </nav>
        <div class="auth">
			<c:if test="<%= object == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= object != null %>">
			    <h2 class="login"><%= object.getLogin() %></h2>
			    <a href="/lab5/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="projects">
        <h3 class="projects__header">Projects</h3>
        <c:if test="<%= object != null && object.getRole_id() == 2%>">
		    <a href="/lab5/EditProjectServlet" class="reg btn">Добавить</a>
		</c:if>
        <table class="projects__table">
            <tr>
                <th><a href="/lab5/ListProjectServlet?table=id">id</a></th>
                <th><a href="/lab5/ListProjectServlet?table=companyid">Компания</a></th>
                <th><a href="/lab5/ListProjectServlet?table=pname">Название проекта</a></th>
                <th><a href="/lab5/ListProjectServlet?table=startdate">Дата начала</a></th>
                <th><a href="/lab5/ListProjectServlet?table=planenddate">Планируемая дата окончания</a></th>
                <th><a href="/lab5/ListProjectServlet?table=enddate">Дата окончания</a></th>
                <th><a href="/lab5/ListProjectServlet?table=managerid">Менеджер</a></th>
                <th><a href="/lab5/ListProjectServlet?table=success">Успешно</a></th>
                
            </tr> 
            <%
                 for(Project project : projects) {
             %>
             		<tr>
             		
	                  <th><%= project.getId() %></th>
                      <th><%= Companies.selectOne(project.getCompanyid()).getCname() %></th>
                 	  <th><%= project.getPname() %></th>
                 	  <th><%= project.getstartdate() %></th>
                 	  <th><%= project.getPlanenddate() %></th>
                 	  <th><%= project.getEnddate() %></th>
                 	  <th><%= Managers.selectOne(project.getManagerid()).getTitle() %></th>
                 	  <th><%= project.getSuccess() ? "Да" : "Нет" %></th>

		              <c:if test="<%= object != null && object.getRole_id() == 2%>">
			    		<td class="edit"><a href="/lab5/EditProjectServlet?id=<%= project.getId() %>"><i class="far fa-edit fa-lg"></i></a></td>
	              		<td class="del"><a href="/lab5/DeleteProject?id=<%= project.getId() %>"><i class="fas fa-trash-alt fa-lg"></i></a></td>
					  </c:if>
	          		</tr> 
             <%
                 }
             %> 
        </table>
    </section>
</body>
</html>