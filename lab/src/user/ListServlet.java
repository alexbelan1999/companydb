package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListUsersServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        ArrayList<User> objects = Users.select(req.getParameter("table"));
        req.setAttribute("objects", objects);
        System.out.println(objects);
        getServletContext().getRequestDispatcher("/view/users.jsp")
                                                      .forward(req, resp);

    }
}