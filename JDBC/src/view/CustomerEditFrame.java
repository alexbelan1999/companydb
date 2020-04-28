package view;

import controller.CustomerButtonListener;
import controller.CustomerDeleteButtonListener;
import controller.CustomerSaveButtonListener;
import domain.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerEditFrame extends JFrame {
    private Long customer_id;
    private JTextField Name;
    private JTextField Adress;

    public CustomerEditFrame(Customer customer) {
        super("ADD / EDIT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 480);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));

        String name = new String();
        String adress = new String();
        if (customer != null) {
            customer_id = customer.getId();
            name = customer.getName();
            adress = customer.getAdress();
        }

        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameFieldLabel = new JLabel("Name :");
        nameFieldLabel.setPreferredSize(new Dimension(150, 30));
        namePanel.add(nameFieldLabel, BorderLayout.WEST);
        Name = new JTextField(name);
        namePanel.add(Name, BorderLayout.CENTER);
        fieldsPanel.add(namePanel);

        JPanel adressPanel = new JPanel(new BorderLayout());
        JLabel adressFieldLabel = new JLabel("Adress:");
        adressFieldLabel.setPreferredSize(new Dimension(150, 30));
        adressPanel.add(adressFieldLabel, BorderLayout.WEST);
        Adress = new JTextField(adress);
        adressPanel.add(Adress, BorderLayout.CENTER);
        fieldsPanel.add(adressPanel);

        add(fieldsPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new BorderLayout());
        JLabel actionsLabel = new JLabel("Action:");
        actionsLabel.setPreferredSize(new Dimension(150, 30));
        buttonsPanel.add(actionsLabel, BorderLayout.WEST);
        JPanel buttonsInnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new CustomerSaveButtonListener(this));
        buttonsInnerPanel.add(saveButton);
        if (customer != null) {
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new CustomerDeleteButtonListener(this));
            buttonsInnerPanel.add(deleteButton);
        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new CustomerButtonListener(this));
        buttonsInnerPanel.add(backButton);
        buttonsPanel.add(buttonsInnerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public Long getCustomerId() {
        return customer_id;
    }

    public Customer getCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(customer_id);

        String name = Name.getText();
        if (name != null && !name.isEmpty()) {
            customer.setName(name);
        } else {
            throw new Exception("Field \"Name\" is empty");
        }
        String adress = Adress.getText();
        if (!adress.isEmpty()) {
            customer.setAdress(adress);
        } else {
            throw new Exception("Field \"Adress\" is empty");
        }

        return customer;
    }

}
