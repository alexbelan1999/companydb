package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dao.UsersDao;
import dao.DaoException;
import company.*;

public class UsersDaoMySqlImpl extends BaseDaoMySqlImpl implements UsersDao {
    @Override
    public Long create(Users user) throws DaoException {
        String sql = "INSERT INTO `users` (`login`, `password`, `role_id`) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            if(user != null) {
                statement.setLong(3, user.getRole().getId());
            } else {
                statement.setNull(3, Types.BIGINT);
            }
            
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            user.setId(id);
            return id;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public Users read(Long id) throws DaoException {
        String sql = "SELECT `login`, `password`, `role_id` FROM `users` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Users user = null;
            if(resultSet.next()) {
                user = new Users();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                
                Long role_id = resultSet.getLong("role_id");
                if(!resultSet.wasNull()) {
                    user.setRole(new Roles());
                    user.getRole().setId(role_id);
                }
            }
            return user;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public List<Users> readByRole(Long role_id) throws DaoException {
        String sql = null;
        if(role_id != null) {
            sql = "SELECT `id`,`login`, `password`, `role_id` FROM `users` WHERE `role_id` = ?";
        } else {
            sql = "SELECT `id`,`login`, `password`, `role_id` FROM `users` WHERE `role_id` IS NULL";
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            Roles role = null;
            if(role_id != null) {
                statement.setLong(1, role_id);
                role = new Roles();
                role.setId(role_id);
            }
            resultSet = statement.executeQuery();
            List<Users> users = new ArrayList<>();
            while(resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(role);
                users.add(user);
            }
            return users;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }
    
    @Override
    public Users readByLogin(String login) throws DaoException {
        String sql = "SELECT `id`, `login`, `password`, `role_id` FROM `users` WHERE `login` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            Users user = null;
            if(resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                
                Long role_id = resultSet.getLong("role_id");
                if(!resultSet.wasNull()) {
                    user.setRole(new Roles());
                    user.getRole().setId(role_id);
                }
            }
            return user;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }
    
    @Override
    public List<Users> readAll() throws DaoException {
        String sql = "SELECT `id`,`login`, `password`, `role_id` FROM `users`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Users> users = new ArrayList<>();
            while(resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                
                Long role_id = resultSet.getLong("role_id");
                if(!resultSet.wasNull()) {
                    user.setRole(new Roles());
                    user.getRole().setId(role_id);
                }
                users.add(user);
            }
            return users;
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { resultSet.close(); } catch(Exception e) {}
            try { statement.close(); } catch(Exception e) {}
        }
    }
    
    @Override
    public void update(Users user) throws DaoException {
        String sql = "UPDATE `users` SET `login` = ?, `password` = ?, `role_id` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            
            if(user.getRole() != null) {
                statement.setLong(3, user.getRole().getId());
            } else {
                statement.setNull(3, Types.BIGINT);
            }
            statement.setLong(4, user.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try { statement.close(); } catch(Exception e) {}
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM `users` WHERE `id` = ?";
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
