package service;

import java.util.List;

import dao.CustomersDao;
import dao.DaoException;
import company.Customers;

public class CustomersServiceImpl implements CustomersService {
    private CustomersDao customerDao;

    @Override
    public List<Customers> findAll() throws ServiceException {
        try {
            return customerDao.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void setCustomersDao(CustomersDao customerDao) throws ServiceException {
        this.customerDao = customerDao;
    }
}