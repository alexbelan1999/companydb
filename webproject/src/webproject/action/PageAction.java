package webproject.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("text", getText());
        String uri = req.getRequestURI();
        req.setAttribute("uri", uri);
        String page = uri.substring(req.getContextPath().length()+1, uri.lastIndexOf(".html"));
        req.setAttribute("page", page);
        return "page";
    }
}
