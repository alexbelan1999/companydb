package controller;

import view.CustomerEditFrame;
import view.CustomersFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAddButtonListener implements ActionListener {
    private CustomersFrame customersFrame;

    public CustomerAddButtonListener(CustomersFrame customersFrame) {
        this.customersFrame = customersFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        customersFrame.setVisible(false);
        new CustomerEditFrame(null);
    }
}
