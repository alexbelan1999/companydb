package by.vsu.course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListCoursesServlet")
public class ListCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        ArrayList<Course> objects = Courses.select(req.getParameter("table"));
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/view/courses.jsp")
                                                      .forward(req, resp);

    }
}