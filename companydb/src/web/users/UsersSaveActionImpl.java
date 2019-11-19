package web.users;

import java.io.IOException;
import java.util.List;
import service.ServiceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.*;
import service.*;
import web.Action;
import web.ActionResult;
import web.ActionResultType;

public class UsersSaveActionImpl implements Action {
    private UsersService service;
    private RolesService rservice;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Users user = getUser(req);
            try {
                service.save(user);
                return new ActionResult("/user/list.html");
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            return new ActionResult("/error", ActionResultType.FORWARD);
        }
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }

    private Users getUser(HttpServletRequest req) throws ServletException, IOException {
        Users user = new Users();
        try {
            user.setId(Long.parseLong(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        
        try {
            Roles role = rservice.findById(Long.parseLong(req.getParameter("role_id")));
            user.setRole(role);
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        
        if(user.getRole() == null || user.getRole().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Роль\"");
        }
        if(user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Логин\"");
        }
        if(user.getPassword()== null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Пароль\"");
        }
        return user;
    }
}