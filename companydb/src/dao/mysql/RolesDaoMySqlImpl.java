package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RolesDao;
import dao.DaoException;
import company.Roles;

public class RolesDaoMySqlImpl extends BaseDaoMySqlImpl implements RolesDao {
    @Override
    public Long create(Roles role) throws DaoException {
        String sql = "INSERT INTO `roles` (`role`) VALUES (?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, role.getRole());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            role.setId(id);
            return id;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public Roles read(Long id) throws DaoException {
        String sql = "SELECT `role` FROM `roles` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Roles role = null;
            if(resultSet.next()) {
                role = new Roles();
                role.setId(id);
                role.setRole(resultSet.getString("role"));
            }
            return role;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Roles> readAll() throws DaoException {
        String sql = "SELECT `id`,`role` FROM `roles`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Roles> roles = new ArrayList<>();
            while(resultSet.next()) {
                Roles role = new Roles();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
            return roles;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void update(Roles role) throws DaoException {
        String sql = "UPDATE `rolse` SET `role` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1,role.getRole());
            statement.setLong(2, role.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM `roles` WHERE `id` = ?";
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