package dao;

import company.Entity;

public interface DAO<T extends Entity> {
    Long create(T entity) throws DaoException;

    T read(Long id) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(Long id) throws DaoException;
}
