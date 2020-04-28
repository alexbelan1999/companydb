package webproject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webproject.action.Action;
import webproject.action.Page0Action;
import webproject.action.PageAction;
import webproject.action.PageHello;
import webproject.action.PageIndex;

public class MyServlet extends HttpServlet {

    private Map<String, Action> map = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        map.put("/page", new PageAction());
        map.put("/page0", new Page0Action());
        map.put("/index", new PageIndex());
        map.put("/hello", new PageHello());
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String key = uri.substring(req.getContextPath().length(), uri.lastIndexOf(".html"));
        String page = map.get(key).execute(req, resp);
        req.getServletContext().getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp").forward(req, resp);
    }
}
