import java.io.IOException;

import java.sql.SQLException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class TeacherEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Teacher object = Storage.readTeacherById(id);
            req.setAttribute("teacher", object);
        } catch(NumberFormatException e) {


        } catch(SQLException e) {
            throw new ServletException(e);
        }
        try{
            Collection<Cathedra> cathedra = Storage.readAllCathedras();
            req.setAttribute("cathedra", cathedra);
            req.setAttribute("teachers", Storage.readAllTeachers());
        }catch (SQLException e){}

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/TeacherEdit.jsp")
                .forward(req, resp);
    }
}