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

public class UsersServiceFindByRoleTest {
    private static void output(UsersService userService, Long role_id) throws ServiceException {
        List<Users> users = userService.findByRole(role_id);
        System.out.printf("Список всех  пользователей с ролью [%d]:\n", role_id);
        System.out.println("================================================");
        for(Users user : users) {
            System.out.println(Utility.toString(user));
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IoCException, ServiceException, PoolException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        IoCConfigurer.configure();
        try(IoCContainer ioc = new IoCContainer()) {
            UsersService userService = ioc.get(UsersService.class);
            System.out.println("======================================================");
            output(userService, 1L);
            output(userService, 2L);
            output(userService, 3L);
        } finally {
            ConnectionPool.getInstance().destroy();
        }
    }
}
