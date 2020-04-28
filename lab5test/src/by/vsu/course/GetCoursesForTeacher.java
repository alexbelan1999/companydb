package by.vsu.course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCoursesForTeacher
 */
@WebServlet("/GetCoursesForTeacher")
public class GetCoursesForTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int teacherId = Integer.parseInt(req.getParameter("teacherId"));
		System.out.println(teacherId);
        ArrayList<Course> objects = Courses.getCoursesForTeacher(teacherId);
        System.out.println(objects);
        req.setAttribute("objects", objects);
        getServletContext().getRequestDispatcher("/view/courses.jsp")
                                                      .forward(req, resp);

    }

}
