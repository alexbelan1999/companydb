package doctor;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveDoctorServlet")
public class SaveDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        Doctor object = new Doctor();
        
        try {
	        object.setSpecId(Integer.parseInt(req.getParameter("special_id")));
	        object.setSurname(req.getParameter("surname"));
	        object.setlName(req.getParameter("name"));
	        object.setPatronymic(req.getParameter("patronymic"));
	        object.setDateBirth(req.getParameter("birth_date"));
	        object.setFirstWorkDateeDate(req.getParameter("first_work_date"));
	        object.setCabinetNumber(Integer.parseInt(req.getParameter("number_of_workplace")));
	       	object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Doctors.insert(object);
        } else {
            Doctors.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}


