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
			System.out.println(worker + " : ���� ������ " + year/365);
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
            if ((worker.gender.compareTo("���") == 0  && year>=55) || (worker.gender.compareTo("���") == 0 && year >= 60 )) {
            	System.out.println(worker);
            }
			
		}
		
		//System.out.println("Count: " + WorkerDB.workers.size());
	}
	
	private static void createWorker() {		
		System.out.print("������� ������� � ��������: ");
		String fio = scanner.next();
		String fio1 = scanner.next();
		System.out.print("������� ���: ");
		String gender = scanner.next();
		
		System.out.print("������� ���� �������� (��.��.����): ");
		String birthdate = scanner.next();
		
		System.out.print("������� ���� ����� �� ������ (��.��.����): ");
		String startworkdate = scanner.next();
		
		System.out.print("������� ���������: ");
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
		System.out.print("������� ����� ��������� ��� ���������� ������: ");
		Integer id = scanner.nextInt();
		
		System.out.print("������� ����� ������� � ��������: ");
		String fio = scanner.next();
		String fio1 = scanner.next();
		System.out.print("������� ����� ���: ");
		String gender = scanner.next();
		
		System.out.print("������� ����� ���� �������� (��.��.����): ");
		String birthdate = scanner.next();
		
		System.out.print("������� ����� ���� ����� �� ������ (��.��.����): ");
		String startworkdate = scanner.next();
		
		System.out.print("������� ����� ���������: ");
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
		System.out.print("������� ����� ��������� ��� �������� ������: ");
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
		commandsNames.add("������ ����������");
		
		commands.put(2, Commands::workexperience);
		commandsNames.add("���� ������ ����������");
		
		commands.put(3, Commands::pensioners);
		commandsNames.add("������ �����������");
		
		commands.put(4, Commands::createWorker);
		commandsNames.add("������� ���������");
		
		commands.put(5, Commands::updateWorker);
		commandsNames.add("�������� ������ ���������");
		
		commands.put(6, Commands::deleteWorker);
		commandsNames.add("������� ������ ���������");
		
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
			System.out.println("��� ����� �������");
		}
	}
	
	private static HashMap<Integer, Runnable> commands;
	private static ArrayList<String> commandsNames;

}
