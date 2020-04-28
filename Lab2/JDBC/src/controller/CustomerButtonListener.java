package controller;

import dao.CustomerDao;
import dao.DaoException;
import dao.DaoFactory;
import domain.Customer;
import view.CustomerEditFrame;
import view.CustomersFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerButtonListener implements ActionListener {
    private CustomerEditFrame customerEditFrame;

    public CustomerButtonListener(CustomerEditFrame customerEditFrame) {
        this.customerEditFrame = customerEditFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try (DaoFactory factory = new DaoFactory()) {
            CustomerDao customerDao = factory.getCustomerDao();
            List<Customer> customers = customerDao.readAll();
            if (customers != null) {
                customerEditFrame.dispose();
            }
            new CustomersFrame(customers);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(customerEditFrame, "Невозможно прочитать данные из базы данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        }
    }
}
