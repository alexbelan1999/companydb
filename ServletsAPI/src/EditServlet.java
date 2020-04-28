import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            MyObject object = Storage.readById(id);
            req.setAttribute("object", object);
        } catch(NumberFormatException e) {}
        getServletContext().getRequestDispatcher("/WEB-INF/edit.html")
                                                      .forward(req, resp);
    }
}