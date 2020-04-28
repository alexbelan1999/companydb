import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(String id : request.getParameterValues("id")) {
			try {
                Storage.delete(Integer.parseInt(id));
            } catch(NumberFormatException e) {

            } catch(SQLException e) {
                throw new ServletException(e);

            }
        }
        response.sendRedirect(request.getContextPath() + "/index.html");
    }
}
