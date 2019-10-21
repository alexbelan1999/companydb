package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;

import java.util.List;

import service.ProjectsService;
import test.Utility;
import company.Projects;

public class ProjectsServiceFindByCustomerTest {
    public static void main(String[] args) throws IoCException {
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        Long customer_id = 1L;
        ProjectsService projectService = ioc.get(ProjectsService.class);
        List<Projects> projects = projectService.findByCustomer(customer_id);
        System.out.printf("Список всех  проектов заказчика [%d]:\n", customer_id);
        System.out.println("================================================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        System.out.println();
    }
    
}