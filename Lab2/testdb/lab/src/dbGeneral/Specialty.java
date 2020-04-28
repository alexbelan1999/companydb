package dbGeneral;

import java.util.ArrayList;
import java.sql.*;

public class Specialty {
	private static String url = "jdbc:mysql://localhost/poliklinika?serverTimezone=Europe/Moscow&useSSL=false";
	private static String login  = "d";
	private static String password = "d";
	
	public static ArrayList<Table> select() {
        
        ArrayList<Table> tables = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT id,name_of_speciality FROM speciality");
                while(resultSet.next()){
                	Table object = new Table();
                	object.setId(resultSet.getInt(1));
                    object.setTitle(resultSet.getString(2));
                    tables.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return tables;
    }
	
	public static Table selectOne(int id) {
		Table object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT id,name_of_speciality FROM speciality WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Table();
                    	object.setId(resultSet.getInt(1));
                        object.setTitle(resultSet.getString(2));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
}

