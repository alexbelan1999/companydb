package by.vsu;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class CalculateButtonHandler2 implements ActionListener {
    private JTextField f1, f2,f3,f4;
    public CalculateButtonHandler2(JTextField f1, JTextField f2,JTextField f3,JTextField f4) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3=f3;
        this.f4=f4;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double x = Double.parseDouble(f1.getText());
            double accuracy = Double.parseDouble(f2.getText());
            double term = ((-1)*x*x*x)/6;
        	double sum = x + term;
        	int n = 1;
        	while (Math.abs(term) > accuracy)
        	{
        	  term = term * (-1)*x*x/((2*n+3)*(2*n+2));
        	  sum = sum + term;
        	  n++;
        	}
            f3.setText(Double.toString(Math.sin(x)));
            f4.setText(Double.toString(sum));
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }

    }
}
