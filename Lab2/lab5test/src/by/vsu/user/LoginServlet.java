package by.vsu.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.vsu.teacher.Teacher;
import by.vsu.teacher.Teachers;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			User object = Users.getUser(login);
			if(object != null && object.getPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", object);
				ArrayList<Teacher> objects = Teachers.select("id");
		        req.setAttribute("objects", objects);
				getServletContext().getRequestDispatcher("/index.jsp")
                .forward(req, resp);
				return;
			}
			
		} catch(NumberFormatException e) {
			getServletContext().getRequestDispatcher("/view/login.html")
            .forward(req, resp);
		}
		
		
		getServletContext().getRequestDispatcher("/view/login.html")
		                              .forward(req, resp);
	}

}
