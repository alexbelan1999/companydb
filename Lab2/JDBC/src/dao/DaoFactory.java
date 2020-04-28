package dao;


import dao.mysql.CustomerMysqlDaoImpl;
import util.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory implements AutoCloseable {
    private Connection connection;


    public CustomerDao getCustomerDao() throws DaoException {
        try {
            CustomerMysqlDaoImpl customerDao = new CustomerMysqlDaoImpl();
            customerDao.setConnection(getConnection());
            return customerDao;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = Connector.getConnection();
        }
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
