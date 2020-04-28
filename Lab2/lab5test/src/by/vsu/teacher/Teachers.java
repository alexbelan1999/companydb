package by.vsu.teacher;

import java.util.ArrayList;
import java.sql.*;

public class Teachers {
	private static String url = "jdbc:mysql://localhost:3306/lb_5?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String login  = "root";
	private static String password = "27061999";
	
	public static ArrayList<Teacher> select(String table) {
        
        ArrayList<Teacher> teachers = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM teachers ORDER BY " + table);
                while(resultSet.next()){
                	Teacher object = new Teacher();
                	object.setId(resultSet.getInt(1));
                    object.setName(resultSet.getString(2));
                    object.setSurname(resultSet.getString(3));
                    object.setPatronymic(resultSet.getString(4));
                    object.setSex(resultSet.getString(5));
                    object.setBirthday(resultSet.getDate(6));
                    object.setDegree(resultSet.getInt(7));
                    object.setPosition(resultSet.getInt(8));
                    teachers.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return teachers;
    }
    public static Teacher selectOne(int id) {
        Teacher object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM teachers WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Teacher();
                    	object.setId(resultSet.getInt(1));
                        object.setName(resultSet.getString(2));
                        object.setSurname(resultSet.getString(3));
                        object.setPatronymic(resultSet.getString(4));
                        object.setSex(resultSet.getString(5));
                        object.setBirthday(resultSet.getDate(6));
                        object.setDegree(resultSet.getInt(7));
                        object.setPosition(resultSet.getInt(8));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }

    public static int insert(Teacher teacher) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
            	
                String sql = "insert into `teachers`(`name`,`surname`,`patronymic`,`sex`,`birthday`,academic_degree_id,position_id) Values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, teacher.getName());
                	preparedStatement.setString(2, teacher.getSurname());
                	preparedStatement.setString(3, teacher.getPatronymic());
                	preparedStatement.setString(4, teacher.getSex());
                	preparedStatement.setDate(5, teacher.getBirthday());
                	preparedStatement.setInt(6, teacher.getDegree());
                	preparedStatement.setInt(7, teacher.getPosition());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(Teacher teacher) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE teachers SET `name` = ?,`surname` = ?,`patronymic` = ?,`sex` = ?,`birthday` = ?,academic_degree_id = ?,position_id = ? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, teacher.getName());
                	preparedStatement.setString(2, teacher.getSurname());
                	preparedStatement.setString(3, teacher.getPatronymic());
                	preparedStatement.setString(4, teacher.getSex());
                	preparedStatement.setDate(5, teacher.getBirthday());
                	preparedStatement.setInt(6, teacher.getDegree());
                	preparedStatement.setInt(7, teacher.getPosition());
                	preparedStatement.setInt(8, teacher.getId());
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
                String sql = "DELETE FROM teachers WHERE id = ?";
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
