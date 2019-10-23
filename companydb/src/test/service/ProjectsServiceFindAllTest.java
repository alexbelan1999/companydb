package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;
import java.util.List;
import service.ServiceException;
import service.ProjectsService;
import test.Utility;
import company.Projects;

public class ProjectsServiceFindAllTest {
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        IoCContainer ioc = new IoCContainer();
        ProjectsService projectService = ioc.get(ProjectsService.class);
        List<Projects> projects = projectService.findAll();
        System.out.println("Список всех проектов");
        System.out.println("===================");
        for(Projects project : projects) {
            System.out.println(Utility.toString(project));
        }
        ConnectionPool.getInstance().destroy();
    }
}