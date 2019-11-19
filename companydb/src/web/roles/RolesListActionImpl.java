package web.roles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Roles;
import service.RolesService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class RolesListActionImpl implements Action {
    private RolesService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Roles> roles = service.findAll();
            req.setAttribute("roles", roles);
            return null;
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void setRolesService(RolesService service) {
        this.service = service;
    }
}