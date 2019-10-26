package web.managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Managers;
import service.ManagersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class ManagersEditActionImpl implements Action {
    private ManagersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try {
                Managers manager = service.findById(id);
                req.setAttribute("manager", manager);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        }
        return null;
    }

    public void setManagersService(ManagersService service) {
        this.service = service;
    }
}