import java.io.IOException;

import java.net.URLEncoder;
import java.sql.SQLException;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pckg.*;

public class TeacherListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            String parameter = req.getParameter("sort");
            Collection<Teacher> objects = Storage.readSortedTeachersByCathedraId(id, parameter);
            req.setAttribute("teacher", objects);
            req.setAttribute("id", id);
        } catch (Exception e) {
            String parameter = "name";
            try{
                Collection<Teacher> objects = Storage.readSortedTeachersByCathedraId(id, parameter);
                req.setAttribute("teacher", objects);
                req.setAttribute("id", id);
            } catch (SQLException sql){
                throw new ServletException(e);
            }
        }
        getServletContext().
                getRequestDispatcher("/WEB-INF/jsp/TeacherIndex.jsp")
                .forward(req, resp);

    }
}