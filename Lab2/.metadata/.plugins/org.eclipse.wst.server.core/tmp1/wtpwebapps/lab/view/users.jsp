<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="user.*"%>
<%@page import="dbGeneral.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ArrayList"%>

<%
	HttpSession ses = request.getSession();
	User object = (User)ses.getAttribute("user");
	@SuppressWarnings("unchecked")
    ArrayList<User> users
                   = (ArrayList<User>)request.getAttribute("objects");
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
            h height: fit-content;
            display: block;
            padding: 10px 0;
            text-align: center;
            border-radius: 4px;
            background-color: #37f422;
            text-decoration: none;
            color: #2502ef;
        }
        .btn:hover {
            background-color: #fdd32a;
        }
        h1, h2 {
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
        .users__header {
            padding: 15px;
            font-size: 25px;
        }

        .users__table {
            width: 90%;
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
            width: 6%;
            margin: 0 auto;
            text-align: center;
        }

    </style>
</head>
<body>
    <header class="header">
        <h1 class="logo">HOSPITAL</h1>
        <nav class="nav">
        	<c:if test="<%= object != null && object.getRole_id() == 1%>">
			    <a href="/lab/ListUsersServlet" class="nav__item btn">users</a>
			</c:if>
            <a href="/lab/index.html" class="nav__item btn">specialities</a>
            <a href="/lab/ListDoctorServlet" class="nav__item btn">doctors</a>
        </nav>
        <div class="auth">
			<c:if test="<%= object == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= object != null %>">
			    <h2 class="login"><%= object.getLogin() %></h2>
			    <a href="/lab/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="users">
        <h3 class="users__header">Users</h3>
        <c:if test="<%= object != null && object.getRole_id() == 1%>">
		    <a href="/lab/EditUserServlet" class="reg btn">Добавить</a>
		</c:if>
        <table class="users__table">
            <tr>
                <th><a href="/lab/ListUsersServlet?table=id">id</a></th>
                <th><a href="/lab/ListUsersServlet?table=login">login</a></th>
                <th><a href="/lab/ListUsersServlet?table=role_id">Роль</a></th>
                <c:if test="<%= object != null && object.getRole_id() == 1%>">
				    <th class="edit"><i class="far fa-edit fa-lg"></i></th>
                	<th class="del"><i class="fas fa-trash-alt fa-lg"></i></th>
				</c:if>
            </tr>
            <%
                 for(User user : users) {
             %>
             		<tr>
		              <td><%= user.getId() %></td>
		              <td><%= user.getLogin() %></td>
		              <td><%= Roles.selectOne(user.getRole_id()).getTitle() %></td>
		              <c:if test="<%= object != null && object.getRole_id() == 1%>">
			    		<td class="edit"><a href="/lab/EditUserServlet?id=<%= user.getId() %>"><i class="far fa-edit fa-lg"></i></a></td>
	              		<td class="del"><a href="/lab/DeleteUser?id=<%= user.getId() %>"><i class="fas fa-trash-alt fa-lg"></i></a></td>
					  </c:if>
	          		</tr> 
             <%
                 }
             %>
        </table>
    </section>
</body>
</html>