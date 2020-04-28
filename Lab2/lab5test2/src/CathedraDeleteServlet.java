import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CathedraDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        for(String id : req.getParameterValues("id")) {
            try {
                Storage.deleteCathedra(Integer.parseInt(id));
            } catch(NumberFormatException e) {

            } catch(SQLException e) {
                throw new ServletException(e);

            }
        }
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}