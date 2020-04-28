<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="by.vsu.user.*"%>
<%@page import="by.vsu.course.*"%>
<%@page import="by.vsu.teacher.*"%>
<%@page import="by.vsu.dbGeneral.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
	HttpSession ses = request.getSession();
	User object = (User)ses.getAttribute("user");
	@SuppressWarnings("unchecked")
    ArrayList<Course> courses
                   = (ArrayList<Course>)request.getAttribute("objects");
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lb 5</title>
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
            background-color: #ffdb4d;
            text-decoration: none;
            color: #000;
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
        .courses__header {
            padding: 15px;
            font-size: 25px;
        }

        .courses__table {
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
        <h1 class="logo">Lb 5</h1>
        <nav class="nav">
        	<c:if test="<%= object != null && object.getRole_id() == 1%>">
			    <a href="/lab5test/ListUsersServlet" class="nav__item btn">users</a>
			</c:if>
            <a href="/lab5test/index.html" class="nav__item btn">teachers</a>
            <a href="/lab5test/ListCoursesServlet" class="nav__item btn">courses</a>
        </nav>
        <div class="auth">
			<c:if test="<%= object == null %>">
			    <a href="view/login.html" class="reg btn">Войти</a>
			</c:if>
			<c:if test="<%= object != null %>">
			    <h2 class="login"><%= object.getLogin() %></h2>
			    <a href="/lab5test/LogoutServlet" class="reg btn">Выйти</a>
			</c:if>
        </div>
    </header>
    <section class="courses">
        <h3 class="courses__header">Courses</h3>
        <c:if test="<%= object != null && object.getRole_id() == 2%>">
		    <a href="/lab5test/EditCourseServlet" class="reg btn">Добавить</a>
		</c:if>
        <table class="courses__table">
            <tr>
                <th><a href="/lab5test/ListCoursesServlet?table=id">id</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=title">Название</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=teacher_id">Преподаватель</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=specialty_id">Cпециальность</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=number_course">Курс</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=semester">Семе</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=count_students">Количество студентов</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=lecture_hours">Лек</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=laborotory_hours">Лаб</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=practical_hours">Практ</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=credit">Зачет</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=exam">Экзамен</a></th>
                <th><a href="/lab5test/ListCoursesServlet?table=count_of_tests">Кр</a></th>
                <th>Часы</th>
                <c:if test="<%= object != null && object.getRole_id() == 2%>">
	    			<th class="edit"><i class="far fa-edit fa-lg"></i></th>
             		<th class="del"><i class="fas fa-trash-alt fa-lg"></i></th>
			  	</c:if>
            </tr> 
            <%
                 for(Course course : courses) {
             %>
             		<tr>
	                  <th><%= course.getId() %></th>
                      <th><%= course.getTitle() %></th>
                 	  <th><%= Teachers.selectOne(course.getTeacherId()).getFullName() %></th>
                	  <th><%= Specialty.selectOne(course.getSpecialtyId()).getTitle() %></th>
                      <th><%= course.getNumberCourse() %></th>
                      <th><%= course.getSemester() %></th>
                      <th><%= course.getCountStudents() %></th>
                      <th><%= course.getLectureHours() %></th>
                      <th><%= course.getLaborotoryHours() %></th>
                      <th><%= course.getPracticalHours() %></th>
                      <th><%= course.isCredit() ? "Да" : "Нет" %></th>
                      <th><%= course.isExam() ? "Да" : "Нет" %></th>
                      <th><%= course.getCountTests() %></th>
                      <th><%= course.getCountHours() %></th>
		              <c:if test="<%= object != null && object.getRole_id() == 2%>">
			    		<td class="edit"><a href="/lab5test/EditCourseServlet?id=<%= course.getId() %>"><i class="far fa-edit fa-lg"></i></a></td>
	              		<td class="del"><a href="/lab5test/DeleteCourse?id=<%= course.getId() %>"><i class="fas fa-trash-alt fa-lg"></i></a></td>
					  </c:if>
	          		</tr> 
             <%
                 }
             %> 
        </table>
    </section>
</body>
</html>