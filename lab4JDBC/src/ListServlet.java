import java.io.IOException;

import java.sql.SQLException;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class ListServlet extends HttpServlet {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/task?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "27061999";


    @Override
    public void init() throws ServletException {

        try {
            Storage.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        	TaskLag.deleteAll();
            Collection<Task> tasks = Storage.readAll();
            Collection<String> str = null;
            str = TaskLag.Taskwithlag();
            request.setAttribute("str", str);
            request.setAttribute("tasks", tasks);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

        } catch(SQLException e) {
            throw new ServletException(e);
        }

    }
}