package select;

import javafx.util.converter.DateTimeStringConverter;

import java.sql.*;
import java.util.Date;

public class lab8 {

    private static final String url;
    private static final String user = "root";
    private static final String password = "27061999";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    static {
        url = "jdbc:mysql://localhost:3306/company";
    }

    public static void main(String args[]) {
        String query = "SELECT id, surname , name, patronymic, start_work, qualification FROM company_workers WHERE id=1;";
        String query1 = "SELECT id, surname, name, patronymic, customers_id, position, e_mail FROM contact_person WHERE id=1;";
        String query2 = "SELECT id, name, address FROM customers WHERE id=1;";
        String query3 = "SELECT id, customer_id, project_name, start_date, plan_end_date, end_date, success FROM project_data WHERE id=1;";
        String query4 = "SELECT id, contact_id, number FROM phone_number WHERE id=1;";
        String query5 = "SELECT id, project_id, worker_id, position, start_work, end_work FROM workers_project WHERE project_id=1;";
        String query6 = "SELECT contact_person.surname, contact_person.name, contact_person.patronymic, phone_number.number FROM contact_person LEFT JOIN phone_number ON contact_person.id=phone_number.contact_id WHERE contact_person.customers_id=1;";
        String query7 = "SELECT company_workers.surname,company_workers.name,company_workers.patronymic,project_data.project_name FROM company_workers LEFT JOIN workers_project ON company_workers.id=workers_project.worker_id LEFT JOIN project_data ON workers_project.project_id=project_data.id WHERE company_workers.id=1;";
        String query8 = "SELECT worker_id,position,start_work FROM workers_project ORDER BY position DESC,start_work DESC;";
        String query9 = "SELECT customers.name AS cname, contact_person.surname,contact_person.name, contact_person.patronymic, phone_number.number FROM customers LEFT JOIN contact_person ON customers.id = contact_person.customers_id  LEFT JOIN phone_number ON (contact_person.id = phone_number.contact_id) WHERE contact_person.customers_id IN (SELECT customers.id FROM customers LEFT JOIN project_data ON (customers.id = project_data.customer_id) WHERE project_data.end_date IS NULL GROUP BY customers.id HAVING COUNT(project_data.customer_id) > 1);";

        try {
        
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            rs = stmt.executeQuery(query);
            System.out.println("SELECT id, surname , name, patronymic, start_work, qualification FROM company_workers WHERE id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                String patronymic = rs.getString(4);
                Date start_work = rs.getDate(5);
                String qualification = rs.getString(6);
                System.out.println("ID : " + id + "  Surname : " + surname + "  Name : " + name  + "  Patronymic : " + patronymic + " Start work : " + start_work + "  Qualification : " + qualification );
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query1);
            System.out.println("SELECT id, surname, name, patronymic, customers_id, position, e_mail FROM contact_person WHERE id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                String patronymic = rs.getString(4);
                int customers_id = rs.getInt(5);
                String position = rs.getString(6);
                String e_mail = rs.getString(7);
                System.out.println("ID : " + id + "  Surname : " + surname + "  Name : " + name  + "  Patronymic : " + patronymic + " Customers id : " + customers_id + "  Position : " + position + "  E-mail : " + e_mail );
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query2);
            System.out.println("SELECT id, name, address FROM customers WHERE id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                
                System.out.println("ID : " + id + "  Name : " + name + "  Address : " + address);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query3);
            System.out.println("SELECT id, customer_id, project_name, start_date, plan_end_date, end_date, success FROM project_data WHERE id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                int custmer_id = rs.getInt(2);
                String project_name = rs.getString(3);
                Date start_date = rs.getDate(4);
                Date plan_end_data = rs.getDate(5);
                Date end_data = rs.getDate(6);
                Boolean success = rs.getBoolean(7);
                System.out.println("ID : " + id + "  Ñustomer id : " + custmer_id + "  Project name : " + project_name + " Start date: " + start_date + " Plan end date: " + plan_end_data + " End date: " + end_data + " Success:  " + success);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        
            rs = stmt.executeQuery(query4);
            System.out.println("SELECT id, contact_id, number FROM phone_number WHERE id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                int contact_id = rs.getInt(2);
                String number = rs.getString(3);
                System.out.println("ID : " + id + "  Contact id : " + contact_id + "  Number : " + number);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query5);
            System.out.println("SELECT id, project_id, worker_id, position, start_work, end_work FROM workers_project WHERE project_id=1");
            while (rs.next()) {
                int id = rs.getInt(1);
                int project_id = rs.getInt(2);
                int worker_id = rs.getInt(3);
                String position = rs.getString(4);
                Date start_work = rs.getDate(5);
                Date end_work = rs.getDate(6);
                System.out.println("ID : " + id + "  Project id : " + project_id + "  Worker id : " + worker_id + "  Position: " + position + " Start work: " + start_work + "  End work: " + end_work);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        
            rs = stmt.executeQuery(query6);
            System.out.println("SELECT contact_person.surname, contact_person.name, contact_person.patronymic, phone_number.number FROM contact_person LEFT JOIN phone_number ON contact_person.id=phone_number.contact_id WHERE contact_person.customers_id=1");
            while (rs.next()) {
               String surname = rs.getString(1);
               String name = rs.getString(2);
               String patronymic = rs.getString(3);
               String number = rs.getString(4);
               System.out.println("Surname : " + surname + "  Name : " + name + "  Patronymic : " + patronymic + "  Number : " + number);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query7);
            System.out.println("SELECT company_workers.surname,company_workers.name,company_workers.patronymic,project_data.project_name FROM company_workers LEFT JOIN workers_project ON company_workers.id=workers_project.worker_id LEFT JOIN project_data ON workers_project.project_id=project_data.id WHERE company_workers.id=1");
            while (rs.next()) {
               String surname = rs.getString(1);
               String name = rs.getString(2);
               String patronymic = rs.getString(3);
               String project_name= rs.getString(4);
               System.out.println("Surname : " + surname + "  Name : " + name + "  Patronymic : " + patronymic + "  Project name : " + project_name);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        
            rs = stmt.executeQuery(query8);
            System.out.println("SELECT worker_id,position,start_work FROM workers_project ORDER BY position DESC,start_work DESC");
            while (rs.next()) {
               int worker_id = rs.getInt(1);
               String position = rs.getString(2);
               Date start_work = rs.getDate(3);
               System.out.println("Worker id : " + worker_id + "  Position : " + position + "  Start work : " + start_work);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            rs = stmt.executeQuery(query9);
            System.out.println("SELECT customers.name, contact_person.surname,contact_person.name, contact_person.patronymic, phone_number.number FROM customers LEFT JOIN contact_person ON customers.id = contact_person.customers_id  LEFT JOIN phone_number ON (contact_person.id = phone_number.contact_id) WHERE contact_person.customers_id IN (SELECT customers.id FROM customers LEFT JOIN project_data ON (customers.id = project_data.customer_id) WHERE project_data.end_date IS NULL GROUP BY customers.id HAVING COUNT(project_data.customer_id) > 1)");
            while (rs.next()) {
               String cname = rs.getString(1);
               String surname = rs.getString(2);
               String name = rs.getString(3);
               String patronymic = rs.getString(4);
               String number = rs.getString(5);
               System.out.println("Customers name : " + cname + "  Surname : " + surname + "  Name : " + name + "  Patronymic : " + patronymic + "  Number: " + number);
            }
           
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        
            
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
           
            try {
                con.close();
            } catch (SQLException se) { }
            try {
                stmt.close();
            } catch (SQLException se) {  }
            try {
                rs.close();
            } catch (SQLException se) {}
        }
    }

}
