package speciality;

import java.util.ArrayList;

import dbGeneral.String;

import java.sql.*;

public class Specialities {
    private static String url = "jdbc:mysql://localhost:3306/companydb?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String login  = "root";
    private static String password = "1234";
	
	public static ArrayList<Speciality> select(String table) {
        
        ArrayList<Speciality> specialities = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM speciality ORDER BY " + table);
                while(resultSet.next()){
                	Speciality object = new Speciality();
                	object.setId(resultSet.getInt(1));
                    object.setName(resultSet.getString(2));
                    object.setnarrow_speciality(resultSet.getBoolean(3));
                    object.setrate_of_pay(resultSet.getDouble(4));
                    specialities.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return specialities;
    }
    public static Speciality selectOne(int id) {
        Speciality object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM speciality WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Speciality();
                    	object.setId(resultSet.getInt(1));
                        object.setName(resultSet.getString(2));
                        object.setnarrow_speciality(resultSet.getBoolean(3));
                        object.setrate_of_pay(resultSet.getDouble(4));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }

    public static int insert(Speciality speciality) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
            	
                String sql = "insert into `speciality`(`name_of_speciality`,`narrow_speciality`,`rate_of_pay`) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, speciality.getName());
                	preparedStatement.setBoolean(2, speciality.getnarrow_speciality());
                	preparedStatement.setDouble(3, speciality.getrate_of_pay());
                
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    
    public static int update(Speciality speciality) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE speciality SET `name_of_speciality` = ?,`narrow_speciality` = ?,`rate_of_pay` = ? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, speciality.getName());
                	preparedStatement.setBoolean(2, speciality.getnarrow_speciality());
                	preparedStatement.setDouble(3, speciality.getrate_of_pay());
                	preparedStatement.setInt(4, speciality.getId());
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
                String sql = "DELETE FROM speciality WHERE id = ?";
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

