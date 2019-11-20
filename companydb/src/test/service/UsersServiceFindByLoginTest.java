package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;
import java.util.List;

import service.UsersService;
import service.ServiceException;
import test.Utility;
import company.Users;

public class UsersServiceFindByLoginTest {
    private static void output(UsersService userService, String login) throws ServiceException {
        Users user = userService.findByLogin(login);
        System.out.printf("Пользователей с логином [%s]:\n", login);
        System.out.println("================================================");
        System.out.println(Utility.toString(user));
        System.out.println();

        System.out.println();
    }
    
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            UsersService userService = ioc.get(UsersService.class);
            System.out.println("======================================================");
            output(userService, "admin");
            output(userService, "manager");
            output(userService, "user");
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}
