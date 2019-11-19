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

public class UsersLoginActionImpl implements Action {
    private UsersService service;
    private CustomersService cservice;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            Users object = new Users(); 
            try {
                object = service.findByLogin(login);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
            if(object != null && object.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("object", object);
                List<Customers>  objects = null;
                try {
                    objects = cservice.findAll();
                } catch(ServiceException e) {
                    throw new ServletException(e);
                }
                
                req.setAttribute("objects", objects);
                return new ActionResult("/index.jsp");
            }
            
        } catch(NumberFormatException e) {
            return new ActionResult("/user/login.html");
        }
        return new ActionResult("/user/login.html");
    }

    public void setUsersService(UsersService service) {
        this.service = service;
    }
    
    public void setCustomersService(CustomersService cservice) {
        this.cservice = cservice;
    }
}