package task4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

class CalculateButtonHandler implements ActionListener {
    private JTextArea textArea;
    private JRadioButton radioButtont1;
    private JRadioButton radioButtont2;
    private JTextField substr;
    public CalculateButtonHandler(JTextArea textArea, JRadioButton radioButtont1, JRadioButton radioButtont2, JTextField substr) {
        this.textArea = textArea;
        this.radioButtont1 = radioButtont1;
        this.radioButtont2 = radioButtont2;
        this.substr = substr;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String input = textArea.getText();
            String[] array = input.split("\n");
            String substring=substr.getText();

            if (radioButtont1.isSelected()) {
                Arrays.sort(array, new StringContanceCompatator(substring));
            }else if (radioButtont2.isSelected()){
                Arrays.sort(array, new StringLengthCompatator());
            }
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < array.length; i++){
                output.append(array[i] + "\n");
            }
            textArea.setText(output.toString());
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Ошибка ввода");
        }
    }
}
