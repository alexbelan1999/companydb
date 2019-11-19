package web.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class UsersLoginActionImpl implements Action {
    private UsersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
            try {
                service.delete(id);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(NumberFormatException e) {}
        return new ActionResult("/user/list.html");
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }
}