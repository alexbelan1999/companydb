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

public class CustomerEditButtonListener implements ActionListener {
    private CustomersFrame customersFrame;

    public CustomerEditButtonListener(CustomersFrame customersFrame) {
        this.customersFrame = customersFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Customer customer = customersFrame.getSelectedCustomer();
        if (customer != null) {
            try (DaoFactory factory = new DaoFactory()) {
                CustomerDao dao = factory.getCustomerDao();
                customer = dao.read(customer.getId());
                if (customer != null) {
                    customersFrame.dispose();
                    new CustomerEditFrame(customer);
                } else {
                    JOptionPane.showMessageDialog(customersFrame, "Not exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(customersFrame, "Unable to read", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(customersFrame, "No one was chosed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
