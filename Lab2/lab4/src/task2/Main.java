package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		WorkerDB.workers = new ArrayList<Worker>();
		
		try {
            Reader reader = new FileReader("company.csv");
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            
            while((line = buffReader.readLine()) != null) {
            	if (line.length() > 0) {
            		String[] data = line.split(";");
            		WorkerDB.add(new Worker(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]));
            	}
            }
            
            buffReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch(IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
		
		Commands.initialize();
		
		Integer command = null;
		
		while (command == null || command != -1) {			
			Commands.showCommands();
			
			System.out.print("Введите команду: ");

			command = Commands.scanner.nextInt();
			
			Commands.run(command);
			
			try {
				Writer writer = new FileWriter("company1.csv");
				for (Worker worker : WorkerDB.workers) {
					writer.write(worker.toCSVFormat() + "\n");
				}
				
				writer.close();
			} catch(IOException e) {
	            System.out.println("Ошибка ввода-вывода");
	        }
			
			System.out.println();
		}	
	}
}
