package test.dao;

import java.util.List;

import test.Utility;
import dao.DaoException;
import dao.CustomersDao;
import dao.fake.CustomersDaoFakeImpl;
import company.Customers;

public class CustomersDaoReadAllTest  {
    public static void main(String[] args) throws DaoException {
        CustomersDao customerDao = new CustomersDaoFakeImpl();
        List<Customers> customers = customerDao.readAll();
        System.out.println("Список всех заказчиков");
        System.out.println("===================");
        for(Customers customer : customers) {
            System.out.println(Utility.toString(customer));
        }
    }
}