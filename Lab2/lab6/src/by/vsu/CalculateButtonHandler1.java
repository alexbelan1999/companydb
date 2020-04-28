package by.vsu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculateButtonHandler1 implements ActionListener {
    private JTextField f1, f2, f3;
    public CalculateButtonHandler1(JTextField f1, JTextField f2, JTextField f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Double a = Double.parseDouble(f1.getText());
            Double b = Double.parseDouble(f2.getText());
            Double c = Double.parseDouble(f3.getText());
            Double d = (a + b/c) * (a - c/b);
            String result = "Результат вычислений " + d;
            JOptionPane.showMessageDialog(null, result);
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}
