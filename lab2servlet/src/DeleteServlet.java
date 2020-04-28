import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(String id : request.getParameterValues("id")) {
            try {
                Storage.delete(Integer.parseInt(id));
            } catch(NumberFormatException e) {}
        }
        response.sendRedirect(request.getContextPath() + "/index.html");
	}

}
