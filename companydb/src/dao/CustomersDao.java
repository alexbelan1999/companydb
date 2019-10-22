package dao;

import java.util.List;
import company.Customers;

public interface CustomersDao extends DAO<Customers> {
    List<Customers> readAll() throws DaoException;
}