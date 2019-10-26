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
import web.ActionResultType;

public class ManagersSaveActionImpl implements Action {
    private ManagersService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Managers manager = getManager(req);
            try {
                service.save(manager);
                return new ActionResult("/manager/list.html");
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            return new ActionResult("/error", ActionResultType.FORWARD);
        }
    }

    public void setManagersService(ManagersService service) {
        this.service = service;
    }

    private Managers getManager(HttpServletRequest req) {
        Managers manager = new Managers();
        try {
            manager.setId(Long.parseLong(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        manager.setSurname(req.getParameter("surname"));
        manager.setName(req.getParameter("name"));
        manager.setPatronymic(req.getParameter("patronymic"));
        if(manager.getName() == null || manager.getName().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Имя\"");
        }
        if(manager.getSurname()== null || manager.getName().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Фамилия\"");
        }
        return manager;
    }
}