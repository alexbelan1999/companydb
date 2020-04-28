package task4;

import javax.swing.*;

class MyForm extends JFrame {
    public MyForm() {
        super("Task 4");
        setBounds(100, 50, 380, 470);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstOperandLabel = new JLabel("Введите строки:");
        firstOperandLabel.setBounds(10, 10, 330, 30);
        add(firstOperandLabel);
        JTextArea firstOperandTextArea = new JTextArea();
        firstOperandTextArea.setBounds(10, 50, 350, 190);
        add(firstOperandTextArea);
        JLabel substringLabel = new JLabel("Введите подстроку:");
        substringLabel.setBounds(60, 240, 330, 30);
        add(substringLabel);
        JTextField substr = new JTextField();
        substr.setBounds(60, 270, 250, 30);
        add(substr);
        JRadioButton buttonForSortOfSmallLetters = new JRadioButton("По позиции последнего вхождения", true);
        buttonForSortOfSmallLetters.setBounds(60, 300, 250, 30);
        JRadioButton buttonForSortOfLength = new JRadioButton("По длине строки");
        buttonForSortOfLength.setBounds(60, 330, 250, 30);
        ButtonGroup group = new ButtonGroup();
        group.add(buttonForSortOfSmallLetters);
        group.add(buttonForSortOfLength);
        add(buttonForSortOfSmallLetters);
        add(buttonForSortOfLength);

        JButton calculateButton = new JButton("Сортировать");
        calculateButton.setBounds(60, 380, 250, 30);
        calculateButton.addActionListener(
                new CalculateButtonHandler(
                        firstOperandTextArea,
                        buttonForSortOfSmallLetters,
                        buttonForSortOfLength,
                        substr
                )
        );
        add(calculateButton);
        validate();
        setVisible(true);
    }
}
