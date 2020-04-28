package webproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Page0Action implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page;
        String id = req.getParameter("id");
        if (req.getParameter("id") == null)
        {
            page = "pageNull";
            req.setAttribute("id", id);
        }
        else
        {
            page = "page0";
            req.setAttribute("id", id);
        }
        return page;
    }
}
