package dao.mysql;

import dao.Dao;
import dao.DaoException;
import domain.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class BaseMySqlDaoImpl<T extends Entity> implements Dao<T> {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public final void delete(Long id) throws DaoException {
        String sql = String.format("DELETE FROM %s WHERE customer_id = ?", getTableName());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
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

    abstract protected String getTableName();
}
