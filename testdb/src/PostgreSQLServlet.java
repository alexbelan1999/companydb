import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testdb.*;

public class PostgreSQLServlet extends HttpServlet {
	public static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://127.0.0.1:5432/subscription";
	static final String USER = "postgres";
	static final String PASSWORD = "27061999";
	@Override
	public void init() throws ServletException 
	{

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
			Collection<Time> Timeall = ExecuteQueries.Execute(number,"c:\\Users\\Алексей\\eclipse-workspace\\testdb\\datap1.txt");
	        request.setAttribute("Timeall", Timeall);
	        getServletContext().getRequestDispatcher("/WEB-INF/jsp/postgresql.jsp").forward(request, response);

		} catch(SQLException e) 
		{
			throw new ServletException(e);
	    }

	}
}

