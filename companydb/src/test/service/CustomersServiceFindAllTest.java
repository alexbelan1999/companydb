package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;

import java.util.List;

import service.CustomersService;
import service.ServiceException;
import test.Utility;
import company.Customers;

public class CustomersServiceFindAllTest {
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            CustomersService customerService = ioc.get(CustomersService.class);
            List<Customers> customers = customerService.findAll();
            System.out.println("Список всех заказчиков");
            System.out.println("===================");
            for(Customers customer : customers) {
                System.out.println(Utility.toString(customer));
            }
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}
