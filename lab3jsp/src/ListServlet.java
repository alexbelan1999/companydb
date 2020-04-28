import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pckg.Task;
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskLag.deleteAll();
        Collection<Task> tasks = Storage.readAll();
        Collection<String> str = null;
        str = TaskLag.Taskwithlag();
        request.setAttribute("str", str);
        request.setAttribute("tasks", tasks);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}