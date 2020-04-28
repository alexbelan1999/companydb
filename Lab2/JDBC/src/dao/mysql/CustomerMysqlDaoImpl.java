package dao.mysql;

import dao.CustomerDao;
import dao.DaoException;
import domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerMysqlDaoImpl extends BaseMySqlDaoImpl<Customer> implements CustomerDao {
    @Override
    public Long create(Customer customer) throws DaoException {
        String sql = "INSERT INTO customer (Name, Adress) VALUES (?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAdress());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long customer_id = resultSet.getLong(1);
            customer.setId(customer_id);
            return customer_id;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public Customer read(Long customer_id) throws DaoException {
        String sql = "SELECT Name, Adress FROM customer WHERE customer_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, customer_id);
            resultSet = statement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(customer_id);
                customer.setName(resultSet.getString("Name"));
                customer.setAdress(resultSet.getString("Adress"));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public List<Customer> readAll() throws DaoException {
        String sql = "SELECT customer_id, Name, Adress FROM customer";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Customer> authors = new ArrayList<>();
            Customer customer = null;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("customer_id"));
                customer.setName(resultSet.getString("Name"));
                customer.setAdress(resultSet.getString("Adress"));
                authors.add(customer);
            }
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void update(Customer customer) throws DaoException {
        String sql = "UPDATE customer SET Name = ?, Adress = ? WHERE customer_id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAdress());
            statement.setLong(3, customer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected String getTableName() {
        return "customer";
    }
}
