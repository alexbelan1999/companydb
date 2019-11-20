package test.service;

import ioc.IoCConfigurer;
import ioc.IoCContainer;
import ioc.IoCException;
import pool.ConnectionPool;
import pool.PoolException;
import java.util.List;
import service.ServiceException;
import service.UsersService;
import test.Utility;
import company.Users;

public class UsersServiceFindAllTest {
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            UsersService userService = ioc.get(UsersService.class);
            List<Users> users = userService.findAll();
            System.out.println("Список всех пользователей");
            System.out.println("===================");
            for(Users user : users) {
                System.out.println(Utility.toString(user));
            }
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}