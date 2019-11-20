package test.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

import dao.DaoException;
import dao.mysql.UsersDaoMySqlImpl;
import company.*;
import pool.ConnectionPool;
import pool.PoolException;
import test.Utility;

public class UsersDaoTest {
    private static void output(List<Users> users, String method, String description) {
        System.out.printf("==================================================\nМетод %s()\nСписок пользователей (%s)\n--------------------------------------------------\n", method, description);
        for(Users user : users) {
            System.out.println(Utility.toString(user));
        }
    }
    private static void output1(Users user, String method, String description) {
        System.out.printf("==================================================\nМетод %s()\nСписок пользователей (%s)\n--------------------------------------------------\n", method, description);
        System.out.println(Utility.toString(user));

    }

    public static void main(String[] args) throws SQLException, PoolException, DaoException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            UsersDaoMySqlImpl userDao = new UsersDaoMySqlImpl();
            userDao.setConnection(connection);
            output(userDao.readAll(), "readAll", "все пользователи");
            output(userDao.readByRole(1L), "readByRole", "все пользователи с 1 ролью");
            output1(userDao.readByLogin("admin"), "readByLogin", "все пользователи с логином admin");
            Users user1 = new Users();
            user1.setLogin("Test");
            user1.setPassword("1111");
            user1.setRole(new Roles());
            user1.getRole().setId(2L);
            Long id1 = userDao.create(user1);
            System.out.printf("==================================================\nМетод create()\nПользователь создан с идентификатором %d\n", id1);
            output(userDao.readByRole(2L), "readByRole", "все пользователи с 2 ролью");
            output1(userDao.readByLogin("Test"), "readByLogin", "все пользователи с логином Test");
            user1 = userDao.read(id1);
            System.out.printf("==================================================\nМетод read()\nПрочитан пользователь с идентификатором %d\n--------------------------------------------------\n", id1);
            System.out.println(Utility.toString(user1));
            user1.setPassword("1122");
            userDao.update(user1);
            System.out.printf("==================================================\nМетод update()\nпользователь с идентификатором %d обновлен\n", id1);
            output(userDao.readAll(), "readAll", "все пользователи");
            userDao.delete(id1);
            System.out.printf("==================================================\nМетод delete()\nпользователь с идентификатором %d удален\n", id1);
            output(userDao.readAll(), "readAll", "все пользователи");
        }
        ConnectionPool.getInstance().destroy();
    }
}