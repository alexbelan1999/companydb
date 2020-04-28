package controller;

import dao.CustomerDao;
import dao.DaoException;
import dao.DaoFactory;
import view.CustomerEditFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDeleteButtonListener implements ActionListener {
    private CustomerEditFrame customerEditFrame;

    public CustomerDeleteButtonListener(CustomerEditFrame customerEditFrame) {
        this.customerEditFrame = customerEditFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (JOptionPane.showConfirmDialog(customerEditFrame, "�� ������������� ������ ������� ������?", "������", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try (DaoFactory factory = new DaoFactory()) {
                CustomerDao customerDao = factory.getCustomerDao();
                customerDao.delete(customerEditFrame.getCustomerId());
                customerEditFrame.dispose();
                new CustomerBackButtonListener(null).actionPerformed(null);
            } catch (DaoException e) {
                JOptionPane.showMessageDialog(customerEditFrame, "���������� ������� ������", "������", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
            }
        }
    }
}
