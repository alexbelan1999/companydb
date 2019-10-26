package service;

import java.util.List;

import company.Customers;
import company.Managers;

public interface CustomersService {
    List<Customers> findAll() throws ServiceException;
    Customers findById(Long id) throws ServiceException;
    void save(Customers customer) throws ServiceException;
    void delete(Long id) throws ServiceException;
}