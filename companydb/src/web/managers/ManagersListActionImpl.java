package web.managers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Managers;
import service.ManagersService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class ManagersListActionImpl implements Action {
    private ManagersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Managers> managers = service.findAll();
            req.setAttribute("managers", managers);
            return null;
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void setManagersService(ManagersService service) {
        this.service = service;
    }
}