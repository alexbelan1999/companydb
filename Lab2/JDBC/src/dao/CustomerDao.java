package dao;

import domain.Customer;

import java.util.List;

public interface CustomerDao extends Dao<Customer> {
    List<Customer> readAll() throws DaoException;
}
