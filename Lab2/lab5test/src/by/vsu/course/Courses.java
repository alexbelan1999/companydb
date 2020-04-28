package by.vsu.course;

import java.util.ArrayList;
import java.sql.*;

public class Courses {
	private static String url = "jdbc:mysql://localhost:3306/lb_5?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String login  = "root";
	private static String password = "27061999";
	
	public static ArrayList<Course> select(String table) {
        
        ArrayList<Course> courses = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM discipline ORDER BY " + table);
                while(resultSet.next()){
                	Course object = new Course();
                	object.setId(resultSet.getInt(1));
                    object.setTitle(resultSet.getString(2));
                    object.setTeacherId(resultSet.getInt(3));
                    object.setSpecialtyId(resultSet.getInt(4));
                    object.setNumberCourse(resultSet.getInt(5));
                    object.setSemester(resultSet.getInt(6));
                    object.setCountStudents(resultSet.getInt(7));
                    object.setLectureHours(resultSet.getInt(8));
                    object.setPracticalHours(resultSet.getInt(9));
                    object.setLaborotoryHours(resultSet.getInt(10));
                    object.setCredit(resultSet.getBoolean(11));
                    object.setExam(resultSet.getBoolean(12));
                    object.setCountTests(resultSet.getInt(13));
                    courses.add(object);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return courses;
    }
    public static Course selectOne(int id) {
        Course object = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "SELECT * FROM discipline WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	object = new Course();
                    	object.setId(resultSet.getInt(1));
                        object.setTitle(resultSet.getString(2));
                        object.setTeacherId(resultSet.getInt(3));
                        object.setSpecialtyId(resultSet.getInt(4));
                        object.setNumberCourse(resultSet.getInt(5));
                        object.setSemester(resultSet.getInt(6));
                        object.setCountStudents(resultSet.getInt(7));
                        object.setLectureHours(resultSet.getInt(8));
                        object.setPracticalHours(resultSet.getInt(9));
                        object.setLaborotoryHours(resultSet.getInt(10));
                        object.setCredit(resultSet.getBoolean(11));
                        object.setExam(resultSet.getBoolean(12));
                        object.setCountTests(resultSet.getInt(13));
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return object;
    }
    public static ArrayList<Course> getCoursesForTeacher(int teacherId) {
        
        ArrayList<Course> courses = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "SELECT * FROM discipline WHERE teacher_id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, teacherId);
                    ResultSet resultSet = preparedStatement.executeQuery();
	                while(resultSet.next()){
	                	Course object = new Course();
	                	object.setId(resultSet.getInt(1));
	                    object.setTitle(resultSet.getString(2));
	                    object.setTeacherId(resultSet.getInt(3));
	                    object.setSpecialtyId(resultSet.getInt(4));
	                    object.setNumberCourse(resultSet.getInt(5));
	                    object.setSemester(resultSet.getInt(6));
	                    object.setCountStudents(resultSet.getInt(7));
	                    object.setLectureHours(resultSet.getInt(8));
	                    object.setPracticalHours(resultSet.getInt(9));
	                    object.setLaborotoryHours(resultSet.getInt(10));
	                    object.setCredit(resultSet.getBoolean(11));
	                    object.setExam(resultSet.getBoolean(12));
	                    object.setCountTests(resultSet.getInt(13));
	                    courses.add(object);
	                }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return courses;
    }
    
    public static int insert(Course course) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){
                String sql = "insert into `discipline`(`title`,`teacher_id`,"
                		+ "`specialty_id`,`number_course`,`semester`,"
                		+ "count_students,lecture_hours,practical_hours,"
                		+ "laborotory_hours,credit,exam,count_of_tests) "
                		+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, course.getTitle());
                	preparedStatement.setInt(2, course.getTeacherId());
                	preparedStatement.setInt(3, course.getSpecialtyId());
                	preparedStatement.setInt(4, course.getNumberCourse());
                	preparedStatement.setInt(5, course.getSemester());
                	preparedStatement.setInt(6, course.getCountStudents());
                	preparedStatement.setInt(7, course.getLectureHours());
                	preparedStatement.setInt(8, course.getPracticalHours());
                	preparedStatement.setInt(9, course.getLaborotoryHours());
                	preparedStatement.setBoolean(10, course.isCredit());
                	preparedStatement.setBoolean(11, course.isExam());
                	preparedStatement.setInt(12, course.getCountTests());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }     
    public static int update(Course course) {     
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, login, password)){ 
                String sql = "UPDATE discipline SET `title`=?,`teacher_id`=?,"  
                		+"`specialty_id`=?,`number_course`=?,`semester`=?," 
                		+"count_students=?,lecture_hours=?,practical_hours=?,"
                		+"laborotory_hours=?,credit=?,exam=?,count_of_tests=? WHERE `id` = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                	preparedStatement.setString(1, course.getTitle());
                	preparedStatement.setInt(2, course.getTeacherId());
                	preparedStatement.setInt(3, course.getSpecialtyId());
                	preparedStatement.setInt(4, course.getNumberCourse());
                	preparedStatement.setInt(5, course.getSemester());
                	preparedStatement.setInt(6, course.getCountStudents());
                	preparedStatement.setInt(7, course.getLectureHours());
                	preparedStatement.setInt(8, course.getPracticalHours());
                	preparedStatement.setInt(9, course.getLaborotoryHours());
                	preparedStatement.setBoolean(10, course.isCredit());
                	preparedStatement.setBoolean(11, course.isExam());
                	preparedStatement.setInt(12, course.getCountTests());
                	preparedStatement.setInt(13, course.getId());
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
                String sql = "DELETE FROM discipline WHERE id = ?";
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
