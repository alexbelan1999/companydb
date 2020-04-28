package by.vsu.project;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.project.*;


@WebServlet("/EditProjectServlet")

public class EditProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Project object = Projects.selectOne(id);
			req.setAttribute("object", object);
		} catch(NumberFormatException e) {}
		
		getServletContext().getRequestDispatcher("/view/editProject.jsp")
		                              .forward(req, resp);
	
	}

}
