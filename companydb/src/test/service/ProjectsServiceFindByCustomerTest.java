package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;
import java.util.List;

import service.ProjectsService;
import service.ServiceException;
import test.Utility;
import company.Projects;

public class ProjectsServiceFindByCustomerTest {
    private static void output(ProjectsService projectService, Long customer_id) throws ServiceException {
        List<Projects> projects = projectService.findByCustomer(customer_id);
        System.out.printf("Список всех  проектов заказчика [%d]:\n", customer_id);
        System.out.println("================================================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            ProjectsService projectService = ioc.get(ProjectsService.class);
            System.out.println("======================================================");
            output(projectService, 1L);
            output(projectService, 2L);
            output(projectService, 3L);
            output(projectService, 4L);
            output(projectService, 5L);
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}
