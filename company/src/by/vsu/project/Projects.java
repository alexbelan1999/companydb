package by.vsu.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import by.vsu.project.Project;

public class Projects {
    private static String url = "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String login  = "root";
    private static String password = "1234";
	
	public static ArrayList<Project> select(String table) {
        
        ArrayList<Project> projects = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM projects ORDER BY " + table);
                while(resultSet.next()){
                	Project object = new Project();
                	object.setId(resultSet.getInt(1));
                    object.setCompanyid(resultSet.getInt(2));
                    object.setPname(resultSet.getString(3));
                    object.setStartdate(resultSet.getString(4));
                    object.setPlanenddate(resultSet.getString(5));
                    object.setEnddate(resultSet.getString(6));
                    object.setManagerid(resultSet.getInt(7));
                    object.setSuccess(resultSet.getBoolean(8));
                    projects.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return projects;
    }
    public static Project selectOne(int id) {
        Project object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM projects WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Project();
                    	object.setId(resultSet.getInt(1));
                        object.setCompanyid(resultSet.getInt(2));
                        object.setPname(resultSet.getString(3));
                        object.setStartdate(resultSet.getString(4));
                        object.setPlanenddate(resultSet.getString(5));
                        object.setEnddate(resultSet.getString(6));
                        object.setManagerid(resultSet.getInt(7));
                        object.setSuccess(resultSet.getBoolean(8));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    public static ArrayList<Project> getProjectForCompany(int companyid) {
        
        ArrayList<Project> projects = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "SELECT * FROM projects WHERE company_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, companyid);
                    ResultSet resultSet = preparedStatement.executeQuery();
	                while(resultSet.next()){
	                	Project object = new Project();
	                	object.setId(resultSet.getInt(1));
	                    object.setCompanyid(resultSet.getInt(2));
	                    object.setPname(resultSet.getString(3));
	                    object.setStartdate(resultSet.getString(4));
	                    object.setPlanenddate(resultSet.getString(5));
	                    object.setEnddate(resultSet.getString(6));
	                    object.setManagerid(resultSet.getInt(7));
	                    object.setSuccess(resultSet.getBoolean(8));
	                    projects.add(object);
	                }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return projects;
    }
    
public static ArrayList<Project> getEndProjectForCompany(int companyid) {
        
        ArrayList<Project> projects = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "SELECT * FROM projects WHERE company_id=? AND LENGTH(end_date) > 1";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, companyid);
                    ResultSet resultSet = preparedStatement.executeQuery();
	                while(resultSet.next()){
	                	Project object = new Project();
	                	object.setId(resultSet.getInt(1));
	                    object.setCompanyid(resultSet.getInt(2));
	                    object.setPname(resultSet.getString(3));
	                    object.setStartdate(resultSet.getString(4));
	                    object.setPlanenddate(resultSet.getString(5));
	                    object.setEnddate(resultSet.getString(6));
	                    object.setManagerid(resultSet.getInt(7));
	                    object.setSuccess(resultSet.getBoolean(8));
	                    projects.add(object);
	                }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return projects;
    }
    
    
    public static int insert(Project project) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "insert into `projects`(`company_id`,`pname`,"
                		+ "`start_date`,`plan_end_date`,`end_date`,`managers_id`,`success`)"
             
                		+ "values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setInt(1, project.getCompanyid());
                	preparedStatement.setString(2, project.getPname());
                	preparedStatement.setString(3, project.getStartdate());
                	preparedStatement.setString(4, project.getPlanenddate());
                	preparedStatement.setString(5, project.getEnddate());
                	preparedStatement.setInt(6, project.getManagerid());
                	preparedStatement.setBoolean(7, project.getSuccess());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(Project project) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE projects SET `company_id`=?,`pname`=?,"  
                		+"`start_date`=?,`plan_end_date`=?,`end_date`=?," 
                		+"managers_id=?,success=? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setInt(1, project.getCompanyid());
                	preparedStatement.setString(2, project.getPname());
                	preparedStatement.setString(3, project.getStartdate());
                	preparedStatement.setString(4, project.getPlanenddate());
                	preparedStatement.setString(5, project.getEnddate());
                	preparedStatement.setInt(6, project.getManagerid());
                	preparedStatement.setBoolean(7, project.getSuccess());
                	preparedStatement.setInt(8, project.getId());
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
                String sql = "DELETE FROM projects WHERE id = ?";
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
