package doctor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetDoctorsForSpeciality")
public class GetDoctorsForSpeciality extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int specialId = Integer.parseInt(req.getParameter("special_id"));
		
        ArrayList<Doctor> objects = Doctors.getDoctorsForSpeciality(specialId);
        System.out.println(objects);
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/view/doctors.jsp")
                                                      .forward(req, resp);

    }

}
