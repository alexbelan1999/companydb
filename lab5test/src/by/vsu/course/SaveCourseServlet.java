package by.vsu.course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveCourseServlet")
public class SaveCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        Course object = new Course();
        object.setTitle(req.getParameter("title"));
        try {
	        object.setTeacherId(Integer.parseInt(req.getParameter("teacher")));
	        object.setSpecialtyId(Integer.parseInt(req.getParameter("specialty")));
	        object.setNumberCourse(Integer.parseInt(req.getParameter("numberCourse")));
	        object.setSemester(Integer.parseInt(req.getParameter("semester")));
	        object.setCountStudents(Integer.parseInt(req.getParameter("countStudents")));
	        object.setLectureHours(Integer.parseInt(req.getParameter("lectureHours")));
	        object.setPracticalHours(Integer.parseInt(req.getParameter("practicalHours")));
	        object.setLaborotoryHours(Integer.parseInt(req.getParameter("laborotoryHours")));
	        object.setCredit(req.getParameter("credit") != null ? req.getParameter("credit").equals("on") : false);
	        object.setExam(req.getParameter("exam") != null ? req.getParameter("exam").equals("on") : false);
	        object.setCountTests(Integer.parseInt(req.getParameter("countTests")));
        	object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Courses.insert(object);
        } else {
            Courses.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
