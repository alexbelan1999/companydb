package dao;

import company.Entity;

public interface DAO<T extends Entity> {
    Long create(T entity);

    T read(Long id);

    void update(T entity);

    void delete(Long id);
}
