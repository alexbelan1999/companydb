import java.io.IOException;

import java.sql.SQLException;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class CathedraListServlet extends HttpServlet {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/cathedras?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "27061999";


    @Override
    public void init() throws ServletException {

        try {
            Storage.init(DRIVER, URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String parameter = req.getParameter("sort");
            Collection<Cathedra> cathedra = Storage.readAllSortedCathedras(parameter);
            Collection<User> users = Storage.readAllUsers();
            req.setAttribute("users", users);
            req.setAttribute("cathedra", cathedra);
            getServletContext().
                    getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            String parameter = "name";
            try {
                Collection<Cathedra> cathedra = Storage.readAllSortedCathedras(parameter);
                Collection<User> users = Storage.readAllUsers();
                req.setAttribute("cathedra", cathedra);
                req.setAttribute("users", users);
                getServletContext().
                        getRequestDispatcher("/WEB-INF/jsp/index.jsp")
                        .forward(req, resp);
            } catch (SQLException sql) {
                throw new ServletException(e);
            }
        }
    }
}