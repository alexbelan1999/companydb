package dao;

import java.util.List;
import company.Roles;

public interface RolesDao extends DAO<Roles> {
    List<Roles> readAll() throws DaoException;
}