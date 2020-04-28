package by.vsu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MyForm1 extends JFrame {
    public MyForm1() {
        super("(a + b/c )*( a - c/b )");
        setBounds(100, 50, 380, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstOperandLabel = new JLabel("a:");
        firstOperandLabel.setBounds(10, 10, 350, 30);
        add(firstOperandLabel);
        JTextField firstOperandTextField = new JTextField();
        firstOperandTextField.setBounds(10, 50, 350, 30);
        add(firstOperandTextField);
        JLabel secondOperandLabel = new JLabel("b:");
        secondOperandLabel.setBounds(10, 90, 350, 30);
        add(secondOperandLabel);
        JTextField secondOperandTextField = new JTextField();
        secondOperandTextField.setBounds(10, 130, 350, 30);
        add(secondOperandTextField);
        JLabel thirdOperandLabel = new JLabel("c:");
        thirdOperandLabel.setBounds(10, 170, 350, 30);
        add(thirdOperandLabel);
        JTextField thirdOperandTextField = new JTextField();
        thirdOperandTextField.setBounds(10, 210, 350, 30);
        add(thirdOperandTextField);
        JButton calculateButton = new JButton("Вычислить результат");
        calculateButton.setBounds(60, 260, 250, 30);
        calculateButton.addActionListener( new CalculateButtonHandler1(firstOperandTextField,secondOperandTextField,thirdOperandTextField));
        add(calculateButton);
        validate();
        setVisible(true);
    }
}


