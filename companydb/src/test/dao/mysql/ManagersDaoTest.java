package test.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DaoException;
import dao.mysql.ManagersDaoMySqlImpl;
import company.Managers;
import pool.ConnectionPool;
import pool.PoolException;
import test.Utility;

public class ManagersDaoTest {
    private static void output(List<Managers> managers) {
        System.out.println("========================================\nМетод readAll()\nСписок всех менеджеров\n----------------------------------------");
        for(Managers manager : managers) {
            System.out.println(Utility.toString(manager));
        }
    }

    public static void main(String[] args) throws SQLException, PoolException, DaoException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            ManagersDaoMySqlImpl managerDao = new ManagersDaoMySqlImpl();
            managerDao.setConnection(connection);
            output(managerDao.readAll());
            Managers manager =new Managers();
            manager.setSurname("Surname");
            manager.setName("Name");
            manager.setPatronymic("Patronymic");
            Long id = managerDao.create(manager);
            System.out.printf("========================================\nМетод create()\nMенеджер создан с идентификатором %d\n", id);
            output(managerDao.readAll());
            manager = managerDao.read(id);
            System.out.printf("========================================\nМетод read()\nПрочитан менеджер  с идентификатором %d\n----------------------------------------\n", id);
            System.out.println(Utility.toString(manager));
            manager.setSurname("Surname1");
            managerDao.update(manager);
            System.out.printf("========================================\nМетод update()\nMенеджер с идентификатором %d обновлён\n", id);
            output(managerDao.readAll());
            managerDao.delete(id);
            System.out.printf("========================================\nМетод delete()\nMенеджер  с идентификатором %d удалён\n", id);
            output(managerDao.readAll());
        }
        ConnectionPool.getInstance().destroy();
    }
}