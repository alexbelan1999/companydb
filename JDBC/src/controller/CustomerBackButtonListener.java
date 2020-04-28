package controller;

import dao.CustomerDao;
import dao.DaoException;
import dao.DaoFactory;
import domain.Customer;
import view.CustomersFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerBackButtonListener implements ActionListener {
    private CustomersFrame customersFrame;

    public CustomerBackButtonListener(CustomersFrame departmentsFrame) {
        this.customersFrame = departmentsFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try (DaoFactory factory = new DaoFactory()) {
            CustomerDao customerDao = factory.getCustomerDao();
            List<Customer> customers = customerDao.readAll();
            if (customersFrame != null) {
                customersFrame.dispose();
            }
            new CustomersFrame(customers);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(customersFrame, "Невозможно прочитать данные из базы данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        }
    }
}
