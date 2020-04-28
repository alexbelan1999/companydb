package speciality;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class ListSpecialityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        ArrayList<Speciality> objects = Specialities.select(req.getParameter("table"));
        System.out.println("1111");
        req.setAttribute("objects", objects);
        System.out.println(objects.size());
        getServletContext().getRequestDispatcher("/index.jsp")
                                                      .forward(req, resp);

    }
}
