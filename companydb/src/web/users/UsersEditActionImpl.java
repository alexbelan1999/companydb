package web.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Users;
import service.UsersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class UsersEditActionImpl implements Action {
    private UsersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try {
                Users user = service.findById(id);
                req.setAttribute("user", user);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        }
        return null;
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }
}