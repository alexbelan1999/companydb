package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveUserServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        User object = new User();
        object.setLogin(req.getParameter("login"));
        object.setPassword(req.getParameter("password"));
        object.setRole_id(Integer.parseInt(req.getParameter("role")));
        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Users.insert(object);
        } else {
            Users.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
	}

}
