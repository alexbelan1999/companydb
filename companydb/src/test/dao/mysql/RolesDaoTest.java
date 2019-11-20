package test.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DaoException;
import dao.mysql.RolesDaoMySqlImpl;
import company.Roles;
import pool.ConnectionPool;
import pool.PoolException;
import test.Utility;

public class RolesDaoTest {
    private static void output(List<Roles> roles) {
        System.out.println("========================================\nМетод readAll()\nСписок всех ролей\n----------------------------------------");
        for(Roles role : roles) {
            System.out.println(Utility.toString(role));
        }
    }

    public static void main(String[] args) throws SQLException, PoolException, DaoException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            RolesDaoMySqlImpl roleDao = new RolesDaoMySqlImpl();
            roleDao.setConnection(connection);
            output(roleDao.readAll());
            Roles role = new Roles();
            role.setRole("test");
            Long id = roleDao.create(role);
            System.out.printf("========================================\nМетод create()\nРоль создана с идентификатором %d\n", id);
            output(roleDao.readAll());
            role = roleDao.read(id);
            System.out.printf("========================================\nМетод read()\nПрочитана роль с идентификатором %d\n----------------------------------------\n", id);
            System.out.println(Utility.toString(role));
            role.setRole("Test1");
            roleDao.update(role);
            System.out.printf("========================================\nМетод update()\nРоль с идентификатором %d обновлёна\n", id);
            output(roleDao.readAll());
            roleDao.delete(id);
            System.out.printf("========================================\nМетод delete()\nРоль с идентификатором %d удалёна\n", id);
            output(roleDao.readAll());
        }
        ConnectionPool.getInstance().destroy();
    }
}