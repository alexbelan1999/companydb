package web.projects;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Projects;
import service.ProjectsService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class ProjectsEditActionImpl implements Action {
    private ProjectsService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            try {
                Projects project = service.findById(id);
                req.setAttribute("project", project);
            } catch(ServiceException e) {
                throw new ServletException(e);
            }
        }
        return null;
    }

    public void setProjectsService(ProjectsService service) {
        this.service = service;
    }
}