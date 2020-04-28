import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import pckg.*;

public class Storage {
    private static String jdbcUrl = null;
    private static String jdbcUser = null;
    private static String jdbcPassword = null;

    public static void init(String jdbcDriver,String jdbcUrl,String jdbcUser,String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        Storage.jdbcUrl = jdbcUrl;
        Storage.jdbcUser = jdbcUser;
        Storage.jdbcPassword = jdbcPassword;
    }

    public static Collection<Task> readAll() throws SQLException {
        String sql = "SELECT `id`, `cipher`, `project_name`, `project_description`, `plan_time`, `actual_time`, `lag_time` " + "FROM `task`";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<Task> tasks = new ArrayList<>();
            while(r.next()) {
                Task task = new Task();
                task.setId(r.getInt("id"));
                task.setCipher(r.getString("cipher"));
                task.setProject_name(r.getString("project_name"));
                task.setProject_description(r.getString("project_description"));
                task.setPlan_time(r.getInt("plan_time"));
                task.setActual_time(r.getInt("actual_time"));
                task.setLag();
                tasks.add(task);
              
            }
            return tasks;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Task readById(Integer id) throws SQLException {
    	String sql = "SELECT `cipher`, `project_name`, `project_description`, `plan_time`, `actual_time`, `lag_time` " + "FROM `task`" + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            Task task = null;
            if(r.next()) {
            	task = new Task();
                task.setId(id);
                task.setCipher(r.getString("cipher"));
                task.setProject_name(r.getString("project_name"));
                task.setProject_description(r.getString("project_description"));
                task.setPlan_time(r.getInt("plan_time"));
                task.setActual_time(r.getInt("actual_time"));
                task.setLag();
            }
            return task;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void create(Task task) throws SQLException {
        String sql = "INSERT INTO `task` "
                   + "(`cipher`, `project_name`, `project_description`, `plan_time`, `actual_time`, `lag_time`) "
                   + "VALUES "
                   + "(?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            System.out.println("Task" + task.getCipher() + " " + task.getProject_name() + " " + task.getProject_description() + " " + task.getPlan_time()+ " "  + task.getActual_time() + " " +  task.getLag());
            s.setString(1, task.getCipher());
            s.setString(2, task.getProject_name());
            s.setString(3, task.getProject_description());
            s.setInt(4, task.getPlan_time());
            s.setInt(5, task.getActual_time());
            s.setInt(6, task.getLag());
            
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void update(Task task) throws SQLException {
        String sql = "UPDATE `task` SET "
                   + "`cipher` = ?, `project_name` = ?, `project_description` = ?, `plan_time` = ?, `actual_time` = ?, `lag_time` = ? "
                   + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, task.getCipher());
            s.setString(2, task.getProject_name());
            s.setString(3, task.getProject_description());
            s.setInt(4, task.getPlan_time());
            s.setInt(5, task.getActual_time());
            s.setInt(6, task.getLag());
            s.setInt(7, task.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM `task` "
                   + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword);
    }
}