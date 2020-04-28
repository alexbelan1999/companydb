import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testdb.*;

public class MSSQLServlet extends HttpServlet {
	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=subscription";
	static final String USER = "admin";
	static final String PASSWORD = "1234";
	@Override
	public void init() throws ServletException {

        try {
            ExecuteQueries.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try 
        {	
        	Integer number = Integer.parseInt(request.getParameter("number"));
        	Collection<Time> Timeall = ExecuteQueries.Execute(number,"c:\\Users\\Алексей\\eclipse-workspace\\testdb\\datams1.txt");
        	request.setAttribute("Timeall", Timeall);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/mssql.jsp").forward(request, response);

        } catch(SQLException e) {
            throw new ServletException(e);
        }

    }
}
