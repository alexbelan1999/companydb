package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomersDao;
import dao.DaoException;
import company.Customers;

public class CustomersDaoMySqlImpl extends BaseDaoMySqlImpl implements CustomersDao {
    @Override
    public Long create(Customers customer) throws DaoException {
        String sql = "INSERT INTO `customers` (`name`, `adress`,`total_pnumber`,`complet_pnumber`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setInt(3, customer.getTotal_pnumber());
            statement.setInt(4, customer.getComplet_pnumber());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            customer.setId(id);
            return id;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public Customers read(Long id) throws DaoException {
        String sql = "SELECT `name`, `adress`,`total_pnumber`,`complet_pnumber` FROM `customers` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Customers customer = null;
            if(resultSet.next()) {
                customer = new Customers();
                customer.setId(id);
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("adress"));
                customer.setTotal_pnumber(resultSet.getInt("total_pnumber"));
                customer.setComplet_pnumber(resultSet.getInt("complet_pnumber"));
            }
            return customer;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Customers> readAll() throws DaoException {
        String sql = "SELECT `name`, `adress`,`total_pnumber`,`complet_pnumber` FROM `customers`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Customers> customers = new ArrayList<>();
            while(resultSet.next()) {
                Customers customer = new Customers();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("adress"));
                customer.setTotal_pnumber(resultSet.getInt("total_pnumber"));
                customer.setComplet_pnumber(resultSet.getInt("complet_pnumber"));
                customers.add(customer);
            }
            return customers;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void update(Customers customer) throws DaoException {
        String sql = "UPDATE `customers` SET `name` = ?, `adress` = ?, `total_pnumber` = ?, `complet_pnumber` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setInt(3, customer.getTotal_pnumber());
            statement.setInt(4, customer.getComplet_pnumber());
            statement.setLong(3, customer.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM `customers` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }
}