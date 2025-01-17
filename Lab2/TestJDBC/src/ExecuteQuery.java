import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import pckg.*;
import java.io.*;

public class ExecuteQuery {
    private static String jdbcUrl = null;
    private static String jdbcUser = null;
    private static String jdbcPassword = null;

    public static void init(String jdbcDriver,String jdbcUrl,String jdbcUser,String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        ExecuteQuery.jdbcUrl = jdbcUrl;
        ExecuteQuery.jdbcUser = jdbcUser;
        ExecuteQuery.jdbcPassword = jdbcPassword;
    }

    public static Collection<Time> Execute() throws SQLException {
        double time1 = 0.0, time2 = 0.0, time3 = 0.0, time4 = 0.0, time5 = 0.0, time6 = 0.0,time7 = 0.0;
        
        Collection<Time> TimeExecute = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        Boolean r = true;
        
        try {
            c = getConnection();
            s = c.createStatement();
            for (int n = 0; n < 3; n++) 
        	{
            	
                long clock1 = 0, clock2 = 0, clock3 = 0, clock4 = 0, clock5 = 0 ;
                long startTime = 0;
                try 
                {
                	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                	BufferedReader fin = new BufferedReader(new FileReader("c:\\Users\\Алексей\\eclipse-workspace\\TestJDBC\\datam1.txt"));
                	String sql;
                    int i = 1;
                    startTime = System.currentTimeMillis();
                	while ((sql = fin.readLine()) != null) 
                	{
                		
                		System.out.println(i + " " + sql);
                		if (i == 5) 
                		{
                			clock1 = System.currentTimeMillis();
                		}
                		if (i == 27) 
                		{
                			clock2 = System.currentTimeMillis();
                		}
                		if (i == 127) 
                		{
                			clock3 = System.currentTimeMillis();
                		}
                		if (i == 128) 
                		{
                			clock4 = System.currentTimeMillis();
                		}
                		if (i == 228) 
                		{
                			clock5 = System.currentTimeMillis();
                		}
                		
                		r = s.execute(sql);
              
                	i = i + 1;
                	}
                	fin.close();
                
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                
                
                long endTime = System.currentTimeMillis();
                time1 = time1 + (clock1 - startTime)/1000.0;
                time2 = time2 + (clock2 - clock1)/1000.0;
                time3 = time3 + (clock3 - clock2)/1000.0;
                time4 = time4 + (clock4 - clock3)/1000.0;
                time5 = time5 + (clock5 - clock4)/1000.0;
                time6 = time6 + (endTime - clock5)/1000.0;
                time7 = time7 + (endTime - startTime)/1000.0;
              
        	}
              
            Time time = new Time();
            
            time.setCreatetime(time1/3);
            time.setInserttime(time2/3);
            time.setSelect1time(time3/3);
            time.setUpdatetime(time4/3);
            time.setSelect2time(time5/3);
            time.setDroptime(time6/3);
            time.setAlltime(time7/3);
            TimeExecute.add(time);
            
            return TimeExecute;
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