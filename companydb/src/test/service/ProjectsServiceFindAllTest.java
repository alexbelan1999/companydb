package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;

import java.util.List;

import service.ProjectsService;
import test.Utility;
import company.Projects;

public class ProjectsServiceFindAllTest {
    public static void main(String[] args) throws IoCException {
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        ProjectsService projectService = ioc.get(ProjectsService.class);
        List<Projects> projects = projectService.findAll();
        System.out.println("Список всех проектов");
        System.out.println("===================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
    }
}