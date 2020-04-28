import controller.CustomerBackButtonListener;
import util.Connector;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connector.init(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "27061999"
            );
            new CustomerBackButtonListener(null).actionPerformed(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Невозможно загрузить драйвер", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}