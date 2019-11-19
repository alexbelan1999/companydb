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
import web.ActionResultType;

public class RolesSaveActionImpl implements Action {
    private RolesService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Roles role = getRole(req);
            try {
                service.save(role);
                return new ActionResult("/role/list.html");
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            return new ActionResult("/error", ActionResultType.FORWARD);
        }
    }

    public void setRolesService(RolesService service) {
        this.service = service;
    }

    private Roles getRole(HttpServletRequest req) {
        Roles role = new Roles();
        try {
            role.setId(Long.parseLong(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        role.setRole(req.getParameter("role"));
        if(role.getRole() == null || role.getRole().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Роль\"");
        }
        return role;
    }
}