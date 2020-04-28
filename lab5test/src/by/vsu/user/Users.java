package by.vsu.user;

import java.util.ArrayList;
import java.sql.*;

public class Users {
	private static String url = "jdbc:mysql://localhost:3306/lb_5?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String login  = "root";
	private static String password = "27061999";
	
	public static ArrayList<User> select(String table) {
        
        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users ORDER BY " + table);
                while(resultSet.next()){
                	User object = new User();
                	object.setId(resultSet.getInt(1));
                    object.setLogin(resultSet.getString(2));
                    object.setPassword(resultSet.getString(3));
                    object.setRole_id(resultSet.getInt(4));
                    users.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }
    public static User selectOne(int id) {
        User object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM users WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new User();
                    	object.setId(resultSet.getInt(1));
                        object.setLogin(resultSet.getString(2));
                        object.setPassword(resultSet.getString(3));
                        object.setRole_id(resultSet.getInt(4));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    public static User getUser(String name) {
        User object = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM users WHERE login=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, name);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new User();
                    	object.setId(resultSet.getInt(1));
                        object.setLogin(resultSet.getString(2));
                        object.setPassword(resultSet.getString(3));
                        object.setRole_id(resultSet.getInt(4));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    public static int insert(User user) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                  
                String sql = "INSERT INTO users (`login`, `password`, role_id) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, user.getLogin());
                	preparedStatement.setString(2, user.getPassword());
                	preparedStatement.setInt(3, user.getRole_id());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(User user) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE users SET `login` = ?, `password` = ?, `role_id` = ? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, user.getLogin());
                	preparedStatement.setString(2, user.getPassword());
                	preparedStatement.setInt(3, user.getRole_id());
                	preparedStatement.setInt(4, user.getId());
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
                String sql = "DELETE FROM users WHERE id = ?";
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
