import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pckg.*;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User object = new User();
        object.setLogin(req.getParameter("login"));
        object.setPassword(req.getParameter("password"));
        object.setRole(req.getParameter("role"));
        try {

            if(object.getLogin() == null) {
                Storage.createUser(object);
            } else {
                Storage.updateUser(object);
            }

        } catch(SQLException e) {
            throw new ServletException(e);
        }


        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}