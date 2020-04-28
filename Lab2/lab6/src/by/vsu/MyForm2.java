package by.vsu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyForm2 extends JFrame {
    public MyForm2() {
        super("Задание 2");
        setBounds(100, 50, 380, 480);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstOperandLabel = new JLabel("x");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        JLabel secondOperandLabel = new JLabel("accuracy");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);
        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);
        JButton calculateButton = new JButton("Вычислить результат");
        calculateButton.setBounds(60, 180, 250, 30);
        JLabel result = new JLabel("Ожидаемый результат SIN(x)");
        result.setBounds(10,220,350,30);
        add(result);
        JTextField resultField = new JTextField();
        resultField.setBounds(10, 260, 350, 30);
        add(resultField);
        JLabel result2 = new JLabel("Ожидаемый результат");
        result2.setBounds(10,300,350,30);
        add(result2);
        JTextField resultField2 = new JTextField();
        resultField2.setBounds(10, 340, 350, 30);
        add(resultField2);
        calculateButton.addActionListener(new CalculateButtonHandler2(firstOperandTextField,secondOperandTextField,resultField,resultField2));
        add(calculateButton);
        validate();
        setVisible(true);
    }
}


