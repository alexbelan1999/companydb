<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="user.*"%>
<%@page import="speciality.*"%>
<%@page import="dbGeneral.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
	HttpSession ses = request.getSession();
	User object = (User)ses.getAttribute("user");
	@SuppressWarnings("unchecked")
    ArrayList<Speciality> specialities
                   = (ArrayList<Speciality>)request.getAttribute("objects");
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
        }
        .btn:hover {
            background-color: #d88e3a;
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
        .specialities__header {
            padding: 15px;
            font-size: 25px;
        }

        .specialities__table {
            width: 90%;
            margin: 15px auto;
            border: 1px solid #091144;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #eee;
            padding: 10px;
        }

        .edit i:hover {
            color: red;
            cursor: pointer;
        }

        .del i:hover {
            color: #ef4502;
            cursor: pointer;
        }

		.edit i, .del i {
        	color: #ef4502;
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
            <a href="/lab/index.html" class="nav__item btn">specalities</a>
            <a href="/lab/ListDoctorServlet" class="nav__item btn">doctors</a>
        </nav>
        <div class="auth">
			<c:if test="<%= object == null %>">
			    <a href="/lab/view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= object != null %>">
			    <h2 class="login"><%= object.getLogin() %></h2>
			    <a href="/lab/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="specialities">
        <h3 class="specialities__header" align="center">Specialities</h3>
        <c:if test="<%= object != null && object.getRole_id() == 2%>">
		    <a href="/lab/EditSpecialityServlet" class="reg btn">Добавить</a>
		</c:if>
        <table class="specialities__table">
            <tr>
                <th><a href="/lab/index.html?table=id">ID</a></th>
                <th><a href="/lab/index.html?table=name_of_speciality">Название</a></th>
                <th><a href="/lab/index.html?table=narrow_speciality">Узкий?</a></th>
                <th><a href="/lab/index.html?table=rate_of_pay">Ставка</a></th>
                
                <th>Количество докторов данной специальности</th>
                <th>Суммарная выплата</th>
                <c:if test="<%= object != null && object.getRole_id() == 2%>">
	    			<th class="edit"><i class="far fa-edit fa-lg"></i></th>
             		<th class="del"><i class="fas fa-trash-alt fa-lg"></i></th>
			  	</c:if>
            </tr>  
            <%
                 for(Speciality speciality : specialities) {
             %>
             		<tr>
	                  <td><a href="/lab/GetDoctorsForSpeciality?special_id=<%= speciality.getId() %>"><%= speciality.getId() %></a></td>
                      <td><%= speciality.getName() %></td>
                 	  <td><%= speciality.getnarrow_speciality() %></td>
                	  <td><%= speciality.getrate_of_pay() %></td>
                      <td><%= speciality.getCountDoctors() %></td>
                      <td><%= speciality.getrate_of_pay()*speciality.getCountDoctors() %></td>
                   
		              <c:if test="<%= object != null && object.getRole_id() == 2%>">
			    		<td class="edit"><a href="/lab/EditSpecialityServlet?id=<%= speciality.getId() %>"><i class="far fa-edit fa-lg"></i></a></td>
	              		<td class="del"><a href="/lab/DeleteSpeciality?id=<%= speciality.getId() %>"><i class="fas fa-trash-alt fa-lg"></i></a></td>
					  </c:if>
	          		</tr> 
             <%
                 }
             %>
        </table>
    </section>
</body>
</html>