package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;

import java.util.List;

import service.ProjectsService;
import test.Utility;
import company.Projects;

public class ProjectsServiceFindByManagerTest {
    public static void main(String[] args) throws IoCException {
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        Long manager_id = 1L;
        ProjectsService projectService = ioc.get(ProjectsService.class);
        List<Projects> projects = projectService.findByManager(manager_id);
        System.out.printf("Список всех  проектов менеджера [%d]:\n", manager_id);
        System.out.println("================================================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        System.out.println();
    }
    
}