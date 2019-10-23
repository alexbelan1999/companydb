package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ManagersDao;
import dao.DaoException;
import company.Managers;

public class ManagersDaoMySqlImpl extends BaseDaoMySqlImpl implements ManagersDao {
    @Override
    public Long create(Managers manager) throws DaoException {
        String sql = "INSERT INTO `managers` (`surname`, `name`,`patronymic`) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, manager.getSurname());
            statement.setString(2, manager.getName());
            statement.setString(3, manager.getPatronymic());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            manager.setId(id);
            return id;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public Managers read(Long id) throws DaoException {
        String sql = "SELECT `surname`, `name`,`patronymic` FROM `managers` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Managers manager = null;
            if(resultSet.next()) {
                manager = new Managers();
                manager.setId(id);
                manager.setSurname(resultSet.getString("surname"));
                manager.setName(resultSet.getString("name"));
                manager.setPatronymic(resultSet.getString("patronymic"));
            }
            return manager;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Managers> readAll() throws DaoException {
        String sql = "SELECT `id`,`surname`, `name`,`patronymic` FROM `managers`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Managers> managers = new ArrayList<>();
            while(resultSet.next()) {
                Managers manager = new Managers();
                manager.setId(resultSet.getLong("id"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setName(resultSet.getString("name"));
                manager.setPatronymic(resultSet.getString("patronymic"));
                managers.add(manager);
            }
            return managers;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void update(Managers manager) throws DaoException {
        String sql = "UPDATE `managers` SET `surname` = ?, `name` = ?, `patronymic` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, manager.getSurname());
            statement.setString(2, manager.getName());
            statement.setString(3, manager.getName());
            statement.setLong(4, manager.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM `managers` WHERE `id` = ?";
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