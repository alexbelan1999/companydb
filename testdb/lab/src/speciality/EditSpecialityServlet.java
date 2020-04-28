package speciality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditSpecialityServlet")
public class EditSpecialityServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Speciality object = Specialities.selectOne(id);
			req.setAttribute("object", object);
		} catch(NumberFormatException e) {}
		
		getServletContext().getRequestDispatcher("/view/editSpeciality.jsp")
		                              .forward(req, resp);
	
	}

}


