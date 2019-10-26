package web.projects;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Projects;
import service.ProjectsService;
import service.ServiceException;
import web.Action;
import web.ActionResult;

public class ProjectsListActionImpl implements Action {
    private ProjectsService service;

    @Override
    public ActionResult exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Projects> projects = service.findAll();
            req.setAttribute("projects", projects);
            return null;
        } catch(ServiceException e) {
            throw new ServletException(e);
        }
    }

    public void setProjectsService(ProjectsService service) {
        this.service = service;
    }
}