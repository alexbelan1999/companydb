import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class CathedraSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Cathedra object = new Cathedra();
        object.setName(req.getParameter("name"));
        object.setPhone(req.getParameter("phone"));
        object.setProfessorRate(Integer.parseInt(req.getParameter("professorRate")));
        object.setDocentRate(Integer.parseInt(req.getParameter("docentRate")));
        object.setSeniorTeacherRate(Integer.parseInt(req.getParameter("seniorTeacherRate")));
        object.setTeacherRate(Integer.parseInt(req.getParameter("teacherRate")));
        object.setProfessorHours(Integer.parseInt(req.getParameter("professorHours")));
        object.setDocentHours(Integer.parseInt(req.getParameter("docentHours")));
        object.setSeniorTeacherHours(Integer.parseInt(req.getParameter("seniorTeacherHours")));
        object.setTeacherHours(Integer.parseInt(req.getParameter("teacherHours")));
        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        try {

            if(object.getId() == null) {
                Storage.createCathedra(object);
            } else {
                Storage.updateCathedra(object);
            }

        } catch(SQLException e) {
            throw new ServletException(e);
        }


        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}