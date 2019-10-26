package service;

import java.util.List;

import dao.CustomersDao;
import dao.DaoException;
import company.Customers;
import company.Managers;

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
    
    @Override
    public Customers findById(Long id) throws ServiceException {
        try {
            return customerDao.read(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Customers customer) throws ServiceException {
        try {
            if(customer.getId() != null) {
                customerDao.update(customer);
            } else {
                customerDao.create(customer);
            }
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            customerDao.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void setCustomersDao(CustomersDao customerDao) throws ServiceException {
        this.customerDao = customerDao;
    }
}