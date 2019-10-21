package service;

import java.util.List;

import dao.CustomersDao;
import company.Customers;

public class CustomersServiceImpl implements CustomersService {
    private CustomersDao customerDao;

    @Override
    public List<Customers> findAll() {
        return customerDao.readAll();
    }

    public void setCustomersDao(CustomersDao customerDao) {
        this.customerDao = customerDao;
    }
}