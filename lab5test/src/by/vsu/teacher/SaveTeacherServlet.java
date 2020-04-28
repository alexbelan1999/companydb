package by.vsu.teacher;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveTeacherServlet")
public class SaveTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        Teacher object = new Teacher();
        object.setName(req.getParameter("name"));
        object.setSurname(req.getParameter("surname"));
        object.setPatronymic(req.getParameter("patronymic"));
        object.setSex(req.getParameter("sex"));
        object.setBirthday(new Date(1999,1,12));
        object.setDegree(Integer.parseInt(req.getParameter("degree")));
        object.setPosition(Integer.parseInt(req.getParameter("position")));
        try {
        	String [] date = req.getParameter("birthday").split("-");
            object.setBirthday(new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Teachers.insert(object);
        } else {
            Teachers.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
