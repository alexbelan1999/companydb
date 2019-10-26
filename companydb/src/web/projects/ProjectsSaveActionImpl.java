package web.projects;

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

public class ProjectsSaveActionImpl implements Action {
    private ProjectsService service;
    private CustomersService cservice;
    private ManagersService mservice;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            Projects project = getProject(req);
            try {
                service.save(project);
                return new ActionResult("/project/list.html");
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        } catch(IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            return new ActionResult("/error", ActionResultType.FORWARD);
        }
    }

    public void setProjectsService(ProjectsService service) {
        this.service = service;
    }

    private Projects getProject(HttpServletRequest req) throws ServletException, IOException {
        Projects project = new Projects();
        try {
            project.setId(Long.parseLong(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        
        try {
            Customers customer = cservice.findById(Long.parseLong(req.getParameter("customer_id")));
            project.setCustomer(customer);
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
        
        project.setProject_name(req.getParameter("project_name"));
        project.setStart_date(req.getParameter("start_date"));
        project.setPlan_end_date(req.getParameter("plan_end_date"));
        project.setEnd_date(req.getParameter("end_date"));
        
        try {
            Managers manager = mservice.findById(Long.parseLong(req.getParameter("manager_id")));
            project.setManager(manager);
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
      
        project.setSuccess(Integer.parseInt(req.getParameter("success")));
        if(project.getCustomer() == null || project.getCustomer().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Заказчик\"");
        }
        if(project.getProject_name()== null || project.getProject_name().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Название\"");
        }
        if(project.getStart_date()== null || project.getStart_date().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Дата начала\"");
        }
        if(project.getPlan_end_date()== null || project.getPlan_end_date().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Планируемая дата окончания\"");
        }
        if(project.getManager()== null || project.getManager().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Менеджер\"");
        }
        if(project.getSuccess()== null || project.getSuccess().toString().isEmpty()) {
            throw new IllegalArgumentException("Не заполнено поле \"Успех\"");
        }
        return project;
    }
}