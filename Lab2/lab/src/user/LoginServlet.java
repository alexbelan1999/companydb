package user;
///////
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import speciality.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			byte[] bytes = password.getBytes("UTF-8") ;
			String encoded = Base64.getEncoder().encodeToString(bytes);	
			User object = Users.getUser(login);
			if(object != null && object.getPassword().equals(encoded)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", object);
				ArrayList<Speciality> objects = Specialities.select("id");
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
