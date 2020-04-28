import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pckg.*;

public class Test extends HttpServlet {
	
	//public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=subscription";
	//static final String USER = "admin";
	//static final String PASSWORD = "1234";
	
	//public static final String DRIVER = "org.postgresql.Driver";
	//static final String URL = "jdbc:postgresql://127.0.0.1:5432/subscription";
	//static final String USER = "postgres";
	//static final String PASSWORD = "27061999";
	
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/subscription?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "27061999";


    @Override
    public void init() throws ServletException {

        try {
            ExecuteQuery.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        	Collection<Time> Timeall = ExecuteQuery.Execute();
        	request.setAttribute("Timeall", Timeall);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

        } catch(SQLException e) {
            throw new ServletException(e);
        }

    }
}
