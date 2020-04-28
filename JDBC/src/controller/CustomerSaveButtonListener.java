package controller;

import dao.CustomerDao;
import dao.DaoException;
import dao.DaoFactory;
import domain.Customer;
import view.CustomerEditFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSaveButtonListener implements ActionListener {
    private CustomerEditFrame customerEditFrame;

    public CustomerSaveButtonListener(CustomerEditFrame customerEditFrame) {
        this.customerEditFrame = customerEditFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Customer customer = customerEditFrame.getCustomer();
            try (DaoFactory factory = new DaoFactory()) {
                CustomerDao customerDao = factory.getCustomerDao();
                if (customer.getId() != null) {
                    customerDao.update(customer);
                } else {
                    customerDao.create(customer);
                }
                customerEditFrame.dispose();
                new CustomerBackButtonListener(null).actionPerformed(null);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(customerEditFrame, "Невозможно сохранить данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(customerEditFrame, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
