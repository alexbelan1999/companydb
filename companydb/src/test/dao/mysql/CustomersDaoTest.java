package test.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DaoException;
import dao.mysql.CustomersDaoMySqlImpl;
import company.Customers;
import pool.ConnectionPool;
import pool.PoolException;
import test.Utility;

public class CustomersDaoTest {
    private static void output(List<Customers> customers) {
        System.out.println("========================================\nМетод readAll()\nСписок всех заказчиков\n----------------------------------------");
        for(Customers customer : customers) {
            System.out.println(Utility.toString(customer));
        }
    }

    public static void main(String[] args) throws SQLException, PoolException, DaoException {
        ConnectionPool.getInstance().init("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
        try(Connection connection = ConnectionPool.getInstance().getConnection()) {
            CustomersDaoMySqlImpl customerDao = new CustomersDaoMySqlImpl();
            customerDao.setConnection(connection);
            output(customerDao.readAll());
            Customers customer =new Customers();
            customer.setName("Company1");
            customer.setAddress("st. Lenina 1");
            customer.setTotal_pnumber(0);
            customer.setComplet_pnumber(0);
            Long id = customerDao.create(customer);
            System.out.printf("========================================\nМетод create()\nЗаказчик создан с идентификатором %d\n", id);
            output(customerDao.readAll());
            customer = customerDao.read(id);
            System.out.printf("========================================\nМетод read()\nПрочитан заказчик с идентификатором %d\n----------------------------------------\n", id);
            System.out.println(Utility.toString(customer));
            customer.setTotal_pnumber(1);
            customerDao.update(customer);
            System.out.printf("========================================\nМетод update()\nЗаказчик с идентификатором %d обновлён\n", id);
            output(customerDao.readAll());
            customerDao.delete(id);
            System.out.printf("========================================\nМетод delete()\nЗаказчик с идентификатором %d удалён\n", id);
            output(customerDao.readAll());
        }
        ConnectionPool.getInstance().destroy();
    }
}