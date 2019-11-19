package web.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Users;
import service.UsersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class UsersListActionImpl implements Action {
    private UsersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Users> users = service.findAll();
            req.setAttribute("users", users);
            return null;
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }
}