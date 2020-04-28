package view;

import domain.Customer;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class CustomerTableModel implements TableModel {
    private static final String[] COLUMNS = {"Name", "Adress"};

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public int getRowCount() {
        if (customers != null) {
            return customers.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (customers != null) {
            Customer customer = customers.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return customer.getName();
                case 1:
                    return customer.getAdress();
            }
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
    }
}
