package web.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.Customers;
import company.Users;
import service.UsersService;
import service.CustomersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class UsersLogoutActionImpl implements Action {
    private UsersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return new ActionResult("/index.jsp");
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }
    

}