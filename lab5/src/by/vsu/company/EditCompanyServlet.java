package by.vsu.company;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.company.*;


@WebServlet("/EditCompanyServlet")

public class EditCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Company object = Companies.selectOne(id);
			req.setAttribute("object", object);
		} catch(NumberFormatException e) {}
		
		getServletContext().getRequestDispatcher("/view/editCompany.jsp")
		                              .forward(req, resp);
	
	}

}
