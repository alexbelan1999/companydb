package task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;

public class Commands {
	public static Scanner scanner;
	private static void showAllWorkers() {
		
		for (Worker worker : WorkerDB.workers) {
			System.out.println(worker);
		}
		
		//System.out.println("Count: " + WorkerDB.workers.size());
	}
	
	private static void workexperience() {
		
		for (Worker worker : WorkerDB.workers) {
			String str = worker.startworkdate;
			Date date = new Date();
            Date dateStartWork = null;
        
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            
            try {
            dateStartWork = format.parse(str);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            long difference = date.getTime() - dateStartWork.getTime();
            int year =  (int)(difference / (24 * 60 * 60 * 1000));
			System.out.println(worker + " : стаж работы " + year/365);
		}
		
		//System.out.println("Count: " + WorkerDB.workers.size());
	}
	
	private static void pensioners() {
		
		for (Worker worker : WorkerDB.workers) {
			String str = worker.birthdate;
			Date date = new Date();
            Date dateBirthDate = null;
        
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            
            try {
            	dateBirthDate = format.parse(str);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            long difference = date.getTime() - dateBirthDate.getTime();
            int year =  (int)(difference / (24 * 60 * 60 * 1000))/365;
            if ((worker.gender.compareTo("жен") == 0  && year>=55) || (worker.gender.compareTo("муж") == 0 && year >= 60 )) {
            	System.out.println(worker);
            }
			
		}
		
		//System.out.println("Count: " + WorkerDB.workers.size());
	}
	
	private static void createWorker() {		
		System.out.print("Введите фамилию и инициалы: ");
		String fio = scanner.next();
		String fio1 = scanner.next();
		System.out.print("Введите пол: ");
		String gender = scanner.next();
		
		System.out.print("Введите дату рождения (дд.мм.гггг): ");
		String birthdate = scanner.next();
		
		System.out.print("Введите дату приёма на работу (дд.мм.гггг): ");
		String startworkdate = scanner.next();
		
		System.out.print("Введите должность: ");
		String position = scanner.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy"); 
		
		try {
			formatter.parse(birthdate); 
			formatter.parse(startworkdate); 
			WorkerDB.add(new Worker(fio + " " + fio1, gender, birthdate, startworkdate, position));
			
			//System.out.println("Count: " + WorkerDB.workers.size());	
		} catch(ParseException e) {
			System.out.println("Wrond datetime format");
		}		
	}
	
	private static void updateWorker() {
		System.out.print("Введите номер работника для обновления данных: ");
		Integer id = scanner.nextInt();
		
		System.out.print("Введите новую фамилию и инициалы: ");
		String fio = scanner.next();
		String fio1 = scanner.next();
		System.out.print("Введите новый пол: ");
		String gender = scanner.next();
		
		System.out.print("Введите новую дату рождения (дд.мм.гггг): ");
		String birthdate = scanner.next();
		
		System.out.print("Введите новую дату приёма на работу (дд.мм.гггг): ");
		String startworkdate = scanner.next();
		
		System.out.print("Введите новую должность: ");
		String position = scanner.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy"); 
		
		try {
			formatter.parse(birthdate); 
			formatter.parse(startworkdate);
			
			for (int i = 0; i < WorkerDB.workers.size(); i++) {
				Worker worker = WorkerDB.workers.get(i);
				if (worker.id == id) {
					
					worker.fio = fio + " " + fio1;
					worker.gender = gender;
					worker.birthdate = birthdate;
					worker.startworkdate = startworkdate;
					worker.position = position;
					
					break;
				}
			}
					
			//System.out.println("Count: " + WorkerDB.workers.size());				
		} catch(ParseException e) {
			System.out.println("Wrond datetime format");
		}	
	}
	
	private static void deleteWorker() {		
		System.out.print("Введите номер работника для удаления данных: ");
		Integer id = scanner.nextInt(); 
		for (int i = 0; i < WorkerDB.workers.size(); i++) {
			if (WorkerDB.workers.get(i).id == id) {
				WorkerDB.workers.remove(i);
				break;
			}
		}
				
		//System.out.println("Count: " + WorkerDB.workers.size());
	}
	
	public static void initialize() {
		scanner = new Scanner(System.in);
		
		commands = new HashMap<Integer, Runnable>();
		commandsNames = new ArrayList<String>();
		
		commands.put(1, Commands::showAllWorkers);
		commandsNames.add("Список работников");
		
		commands.put(2, Commands::workexperience);
		commandsNames.add("Стаж работы работников");
		
		commands.put(3, Commands::pensioners);
		commandsNames.add("Список пенсионеров");
		
		commands.put(4, Commands::createWorker);
		commandsNames.add("Создать работника");
		
		commands.put(5, Commands::updateWorker);
		commandsNames.add("Обновить данные работника");
		
		commands.put(6, Commands::deleteWorker);
		commandsNames.add("Удалить данные работника");
		
	}
	
	public static void showCommands() {
		int number = 1;
		
		for (String command : commandsNames) {
			System.out.println((number++) + ": " + command);
		}
		
		System.out.println();
	}
	
	public static void run(Integer command) {
		if (commands.containsKey(command)) {
			commands.get(command).run();
		} else {
			System.out.println("Нет такой команды");
		}
	}
	
	private static HashMap<Integer, Runnable> commands;
	private static ArrayList<String> commandsNames;

}
