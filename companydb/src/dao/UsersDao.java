package dao;

import java.util.List;
import company.Users;

public interface UsersDao extends DAO<Users> {
    List<Users> readByRole(Long role_id) throws DaoException;
    Users readByLogin(String login) throws DaoException;
    List<Users> readAll() throws DaoException;
}