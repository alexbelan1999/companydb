import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Task task = Storage.readById(id);
            request.setAttribute("task", task);
        } catch(NumberFormatException e) {}
        getServletContext().getRequestDispatcher("/WEB-INF/edit.html").forward(request, response);
    }
}
