package doctor;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListDoctorServlet")
public class ListDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        ArrayList<Doctor> objects = Doctors.select(req.getParameter("table"));
        
        for (Doctor object : objects) {
            try {
				Doctors.setSalaryForDoc(object);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
           
        }
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/view/doctors.jsp")
                                                      .forward(req, resp);

    }
}

