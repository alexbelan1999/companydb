package speciality;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	
@WebServlet("/SaveSpecialityServlet")
public class SaveSpecialityServlet extends HttpServlet 
{
		private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
	        Speciality object = new Speciality();
	        object.setName(req.getParameter("name_of_speciality"));
	        object.setnarrow_speciality(Boolean.parseBoolean(req.getParameter("narrow_speciality")));
	        object.setrate_of_pay(Double.parseDouble(req.getParameter("rate_of_pay")));

	        try {
	        	
	            object.setId(Integer.parseInt(req.getParameter("id")));
	        } catch(NumberFormatException e) {}
	        if(object.getId() == null) {
	            Specialities.insert(object);
	        } else {
	            Specialities.update(object);
	        }

	        resp.sendRedirect(req.getContextPath() + "/index.html");
		}

}



