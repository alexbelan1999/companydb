package web.roles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RolesService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class RolesDeleteActionImpl implements Action {
    private RolesService service;

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
        return new ActionResult("/role/list.html");
    }

    public void setRolesService(RolesService service) {
        this.service = service;
    }
}