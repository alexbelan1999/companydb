package doctor;

import java.util.ArrayList;

import speciality.*;


import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

public class Doctors {
	private static String url = "jdbc:mysql://localhost/poliklinika?serverTimezone=Europe/Moscow&useSSL=false";
	private static String login  = "d";
	private static String password = "d";
	
	public static ArrayList<Doctor> select(String table) {
        
        ArrayList<Doctor> doctors = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM doctor ORDER BY " + table);
                while(resultSet.next()){
                	Doctor object = new Doctor();
                	object.setId(resultSet.getInt(1));
                    object.setSpecId(resultSet.getInt(2));
                    object.setSurname(resultSet.getString(3));
                    object.setlName(resultSet.getString(4));
                    object.setPatronymic(resultSet.getString(5));
                    object.setDateBirth(resultSet.getString(6));
                    object.setFirstWorkDateeDate(resultSet.getString(7));
                    object.setCabinetNumber(resultSet.getInt(8));
                   
                    doctors.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return doctors;
    }
	public static void setSalaryForDoc(Doctor doctor) throws SQLException {
        LocalDate date = LocalDate.parse(doctor.getFirstWorkDate());
        LocalDate now = LocalDate.now();

        double rate = Specialities.selectOne(doctor.getSpecialId()).getrate_of_pay();
        double salary = 0;
        Period period = Period.between(now, date);
        int years = Math.abs(period.getYears());
        if (years < 5) {
            salary = rate;
        }
        if (years >= 5 && years < 10) {
            salary = rate + rate * 0.05;
        }
        if (years >= 10 && years < 20) {
            salary = rate + rate * 0.1;
        }
        if (years >= 20 && years < 35) {
            salary = rate + rate * 0.15;
        }
        if (years >= 35) {
            salary = rate + rate * 0.2;
        }
        doctor.setSalary(salary);
    }
	
    public static Doctor selectOne(int id) {
        Doctor object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM doctor WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Doctor();
                    	object.setId(resultSet.getInt(1));
                        object.setSpecId(resultSet.getInt(2));
                        object.setSurname(resultSet.getString(3));
                        object.setlName(resultSet.getString(4));
                        object.setPatronymic(resultSet.getString(5));
                        object.setDateBirth(resultSet.getString(6));
                        object.setFirstWorkDateeDate(resultSet.getString(7));
                        object.setCabinetNumber(resultSet.getInt(8));
                        
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    public static ArrayList<Doctor> getDoctorsForSpeciality(int specialId) {
        
        ArrayList<Doctor> doctors = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "SELECT * FROM doctor WHERE special_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, specialId);
                    ResultSet resultSet = preparedStatement.executeQuery();
	                while(resultSet.next()){
	                	Doctor object = new Doctor();
	                	object = new Doctor();
                    	object.setId(resultSet.getInt(1));
                        object.setSpecId(resultSet.getInt(2));
                        object.setSurname(resultSet.getString(3));
                        object.setlName(resultSet.getString(4));
                        object.setPatronymic(resultSet.getString(5));
                        object.setDateBirth(resultSet.getString(6));
                        object.setFirstWorkDateeDate(resultSet.getString(7));
                        object.setCabinetNumber(resultSet.getInt(8));
	                    doctors.add(object);
	                }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return doctors;
    }
    
    public static int insert(Doctor doctor) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "insert into `doctor`(`special_id`,`surname`,"
                		+ "`name`,`patronymic`,`birth_date`," 
                		+ "`first_work_date`,number_of_workplace)"
                   		+ "Values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setInt(1, doctor.getSpecialId());
                	preparedStatement.setString(2, doctor.getSurname());
                	preparedStatement.setString(3, doctor.getName());
                	preparedStatement.setString(4, doctor.getPatronymic());
                	preparedStatement.setString(5, doctor.getDateBirth());
                	preparedStatement.setString(6, doctor.getFirstWorkDate());
                	preparedStatement.setInt(7, doctor.getCabinetNumber());
                	
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(Doctor doctor) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE doctor SET `special_id`=?,`surname`=?,"  
                		+"`name`=?,`patronymic`=?,`birth_date`=?," 
                		+"`first_work_date`=?,`number_of_workplace`=? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setInt(1, doctor.getSpecialId());
                	preparedStatement.setString(2, doctor.getSurname());
                	preparedStatement.setString(3, doctor.getName());
                	preparedStatement.setString(4, doctor.getPatronymic());
                	preparedStatement.setString(5, doctor.getDateBirth());
                	preparedStatement.setString(6, doctor.getFirstWorkDate());
                	preparedStatement.setInt(7, doctor.getCabinetNumber());
                	preparedStatement.setInt(8, doctor.getId());
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "DELETE FROM doctor WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);  
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}

