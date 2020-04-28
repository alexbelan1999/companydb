package speciality;
import doctor.*;

public class Speciality {
	private Integer id;
	private String name_of_speciality;
	private boolean narrow_speciality ;
	private double rate_of_pay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name_of_speciality;
	}
	public void setName(String name) {
		this.name_of_speciality = name;
	}
	public boolean getnarrow_speciality() {
		return narrow_speciality;
	}
	public void setnarrow_speciality(boolean degree) {
		this.narrow_speciality = degree;
	}
	public double getrate_of_pay() {
		return rate_of_pay;
	}
	public void setrate_of_pay(double rate) {
		this.rate_of_pay = rate;
	}
	public int getCountDoctors() {
		return Doctors.getDoctorsForSpeciality(this.id).size();
	}

}
