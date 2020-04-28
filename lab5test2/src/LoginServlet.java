import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pckg.User;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login != null && password != null) {
            /* условие выполняется, если сервлету была передана
             * форма авторизации */
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            User object = new User();
            try {
                object = Storage.checkUser(user);
            }
            catch (SQLException e){
                object = null;
            }
                if(object != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("object", object);
                    System.out.println(object.getRole());
                    resp.sendRedirect(req.getContextPath() + "/index.html");
                } else {
                    String message = "Имя пользователя или пароль неопознанны";
                    String url = req.getContextPath()
                            + "/login-form.html?message="
                            + URLEncoder.encode(message, "UTF-8");
                    resp.sendRedirect(url);
                }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login-form.html");
        }
    }
}