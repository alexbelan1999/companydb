package by.vsu.company;
import java.util.ArrayList;
import java.sql.*;
import by.vsu.company.*;
public class Companies {
	private static String url = "jdbc:mysql://localhost:3306/lab5?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String login  = "root";
	private static String password = "27061999";
	
	public static ArrayList<Company> select(String table) {
        
        ArrayList<Company> companies = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM companies ORDER BY " + table);
                while(resultSet.next()){
                	Company object = new Company();
                	
                	object.setId(resultSet.getInt(1));
                	object.setCname(resultSet.getString(2));
                    object.setAddress(resultSet.getString(3));
                    companies.add(object);
                   
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return companies;
    }
    public static Company selectOne(int id) {
        Company object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM companies WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Company();
                    	object.setId(resultSet.getInt(1));
                    	object.setCname(resultSet.getString(2));
                        object.setAddress(resultSet.getString(3));
                      
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }

    public static int insert(Company company) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
            	
                String sql = "insert into `companies`(`cname`,`address`) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, company.getCname());
                	preparedStatement.setString(2, company.getAddress());
           
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(Company company) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE companies SET `cname` = ?,`address` = ? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, company.getCname());
                	preparedStatement.setString(2, company.getAddress());
                	preparedStatement.setInt(3, company.getId());
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
                String sql = "DELETE FROM companies WHERE id = ?";
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