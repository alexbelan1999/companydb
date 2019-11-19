package web.roles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Roles;
import service.RolesService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class RolesEditActionImpl implements Action {
    private RolesService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try {
                Roles role = service.findById(id);
                req.setAttribute("role", role);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        }
        return null;
    }

    public void setRolesService(RolesService service) {
        this.service = service;
    }
}