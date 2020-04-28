package task2;

import java.util.ArrayList;

public class WorkerDB {
	public static void add(Worker worker) {
		workers.add(worker);
		worker.id = workers.size();
	}
	
	public static ArrayList<Worker> workers;

}
