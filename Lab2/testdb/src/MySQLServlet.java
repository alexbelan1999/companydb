import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testdb.*;

public class MySQLServlet extends HttpServlet {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/subscription?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "27061999";


    @Override
    public void init() throws ServletException {

        try 
        {
            ExecuteQueries.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) 
        {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try 
        {	
        	Integer number = Integer.parseInt(request.getParameter("number"));
        	Collection<Time> Timeall = ExecuteQueries.Execute(number,"c:\\Users\\Алексей\\eclipse-workspace\\testdb\\datam1.txt");
        	request.setAttribute("Timeall", Timeall);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/mysql.jsp").forward(request, response);

        } catch(SQLException e) 
        {
            throw new ServletException(e);
        }

    }
}

