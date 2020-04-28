package doctor;



public class Doctor {
	 private Integer id;
     private Integer special_id;
	 private String surname;
	 private String name;
	 private String patronymic;
	 private String birth_date;
	 private String first_work_date;
	 private Integer number_of_workplace;
	 private Double salary;
	 

	 public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getSpecialId() {
	        return special_id;
	    }

	    public void setSpecId(Integer specId) {
	        this.special_id = specId;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    }

	    public String getPatronymic() {
	        return patronymic;
	    }

	    public void setPatronymic(String sName) {
	        this.patronymic = sName;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setlName(String lName) {
	        this.name = lName;
	    }

	    public String getDateBirth() {
	        return birth_date;
	    }

	    public void setDateBirth(String dateBirth) {
	        this.birth_date = dateBirth;
	    }

	    public String getFirstWorkDate() {
	        return first_work_date;
	    }

	    public void setFirstWorkDateeDate(String eDate) {
	        this.first_work_date = eDate;
	    }

	    public Integer getCabinetNumber() {
	        return number_of_workplace;
	    }

	    public void setCabinetNumber(Integer nStage) {
	        this.number_of_workplace = nStage;
	    }

	    public Double getSalary() {
	    	
	        return salary;
	    }

	    public void setSalary(Double salary) {
	        this.salary = salary;
	    }
	

}
