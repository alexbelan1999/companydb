package view;

import controller.CustomerAddButtonListener;
import controller.CustomerEditButtonListener;
import domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomersFrame extends JFrame {
    private CustomerTableModel customerTableModel = new CustomerTableModel();
    private JTable customerTable;

    public CustomersFrame(List<Customer> customers) {
        super("List");
        customerTableModel.setCustomers(customers);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 480);

        /* TOP */
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("List of customers");
        titleLabel.setFont(new Font("Arial Black", Font.ITALIC, 26));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        /* CENTER */
        customerTable = new JTable(customerTableModel);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane authorsScrollPane = new JScrollPane(customerTable);
        add(authorsScrollPane, BorderLayout.CENTER);

        /* BOTTOM */
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new CustomerAddButtonListener(this));
        addButton.setPreferredSize(new Dimension(150, 25));
        controlPanel.add(addButton);
        JButton editButton = new JButton("EDIT");
        editButton.addActionListener(new CustomerEditButtonListener(this));
        editButton.setPreferredSize(new Dimension(150, 25));

        controlPanel.add(editButton);
        add(controlPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public Customer getSelectedCustomer() {
        Customer customer = null;
        int index = customerTable.getSelectedRow();
        if (index != -1) {
            customer = customerTableModel.getCustomers().get(index);
        }
        return customer;
    }
}
