package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;
import java.util.List;

import service.ManagersService;
import service.ServiceException;
import test.Utility;
import company.Managers;

public class ManagersServiceFindAllTest {
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            ManagersService managerService = ioc.get(ManagersService.class);
            List<Managers> managers = managerService.findAll();
            System.out.println("Список всех менеджеров");
            System.out.println("===================");
            for(Managers manager : managers) {
                System.out.println(Utility.toString(manager));
            }
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}