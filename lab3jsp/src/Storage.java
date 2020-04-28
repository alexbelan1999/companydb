import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import pckg.*;
public class Storage {
    private static Map<Integer, Task> tasks = new HashMap<>();
    private static ArrayList<Task> tasklist = new ArrayList<Task>();
    static {
    	
        
        /*task = new Task();
        task.setCipher("100A200B");
        task.setProject_name("First project");
        task.setProject_description("Simple project");
        task.setPlan_time(4);
        task.setActual_time(6);
        task.setLag();
        create(task);
        tasklist.add(task);
        task = new Task();
        task.setCipher("100A250B");
        task.setProject_name("Web app");
        task.setProject_description("Servlet API");
        task.setPlan_time(5);
        task.setActual_time(6);
        task.setLag();
        create(task);
        tasklist.add(task);
        task = new Task();
        task.setCipher("200A350B");
        task.setProject_name("Calculator");
        task.setProject_description("+-*");
        task.setPlan_time(10);
        task.setActual_time(8);
        task.setLag();
        create(task);
        tasklist.add(task);
        task = new Task();
        task.setCipher("400C350F");
        task.setProject_name("Database");
        task.setProject_description("Mysql");
        task.setPlan_time(24);
        task.setActual_time(27);
        task.setLag();
        create(task);
        tasklist.add(task);
        try(ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("c:\\Users\\Алексей\\eclipse-workspace\\lab2servlet\\src\\taskstorage.dat"))){
        	
            oos.writeObject(tasklist);
            oos.flush();
            oos.close();

        }
        catch(Exception e){
            System.out.println("Error!" + e.getMessage());
   
        }
        try(ObjectInputStream ios =  new ObjectInputStream(new FileInputStream("c:\\Users\\Алексей\\eclipse-workspace\\lab2servlet\\src\\taskstorage.dat"))){
            tasklistnew = (ArrayList<Task>)ios.readObject();
            for(Task t: tasklistnew)
            {
            create(t);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        try {
            InputStream is = new FileInputStream("c:\\Users\\Алексей\\eclipse-workspace\\lab3jsp\\src\\taskstorage.dat");
            ObjectInputStream ois = new ObjectInputStream(is);
            tasklist = (ArrayList<Task>)ois.readObject();
            ois.close();
            for (Task task : tasklist) {
                update(task);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Collection<Task> readAll() {
    	try {
            OutputStream os = new FileOutputStream("c:\\Users\\Алексей\\eclipse-workspace\\lab3jsp\\src\\taskstorage.dat");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ArrayList<Task> listnew = new ArrayList<Task>(tasks.values());
            oos.writeObject(listnew);
            oos.close();
        } 
    	catch(IOException e) {
            System.out.println("Невозможно сохранить файл");
        }

    	return tasks.values();
    }

    public static Task readById(Integer id) {
        return tasks.get(id);
    }

    public static void create(Task task) {
        /* минимальное значение идентификатора */
        Integer id = 1;
        /* множество идентификаторов всех объектов в списке */
        Set<Integer> ids = tasks.keySet();
        if(!ids.isEmpty()) {
            /* вычисление идентификатора, на 1 большего
             * максимального из существующего */
            id += Collections.max(ids);
        }
        task.setId(id);
        tasks.put(id, task);
        tasklist.add(task);
    }
    public static void update(Task task) {
        tasks.put(task.getId(), task);
    }

    public static void delete(Integer id) {
        tasks.remove(id);
    }
    public static Map<Integer, Task> getObjects() {
        return tasks;
    }
}