package task2;

public class Worker {
	public int id;
	public String fio;
	public String gender;
	public String birthdate;
	public String startworkdate;
	public String position;
	
	public Worker(String fio, String gender, String birthdate, String startworkdate, String position) {
		this.fio = fio;
		this.gender = gender;
		this.birthdate = birthdate;
		this.startworkdate = startworkdate;
		this.position = position;
	}
	public Worker(Integer id, String fio, String gender, String birthdate, String startworkdate, String position) {
		this.id = id;
		this.fio = fio;
		this.gender = gender;
		this.birthdate = birthdate;
		this.startworkdate = startworkdate;
		this.position = position;
	}
	
	public String toString() {
		return id + " : " + fio + " : " + gender + " : " + birthdate + " : " + startworkdate + " : " + position;
	}
	
	public String toCSVFormat() {
		return id + ";" + fio + ";" + gender + ";" + birthdate + ";" + startworkdate + ";" + position;
	}
}
