import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;

import pckg.*;
public class TaskLag {
	private static HashMap<String, Integer> objectsTasks = new HashMap<>();

    public static Collection<String> Taskwithlag() throws ServletException {
    	Collection<String> coll = new ArrayList<>();
    	try {
    		Collection<Task> tasks = Storage.readAll();
    		//Collection<String> coll = new ArrayList<>();
    		for(Task task : tasks)
    		{
    			if(!objectsTasks.containsKey(task.getProject_name())){
            	objectsTasks.put(task.getProject_name(), task.getLag());
    			}
    			else {
            	
    			}
    		}
    		int max = -1;
            for (Map.Entry entry : objectsTasks.entrySet()) 
            {
                if ((Integer)entry.getValue() > max){
                    max = (Integer)entry.getValue();
                }
            }
            for(Map.Entry entry : objectsTasks.entrySet())
            {
                if(entry.getValue().equals(max)) {
                	coll.add((String)entry.getKey());
                }
       
            }
         } catch(SQLException e) 
    	{
    	   throw new ServletException(e);
    	}   
            return coll;  
    }

    public static void deleteAll() {
    	objectsTasks.keySet().removeAll(objectsTasks.keySet());
    }

}
