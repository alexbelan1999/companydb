package by.vsu.course;

public class Course {
	private Integer id;
	private String title;
	private int teacherId;
	private int specialtyId;
	private int numberCourse;
	private int semester;
	private int countStudents;
	private int lectureHours;
	private int practicalHours;
	private int laborotoryHours;
	private boolean credit;
	private boolean exam;
    private int countTests;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}
	public int getNumberCourse() {
		return numberCourse;
	}
	public void setNumberCourse(int numberCourse) {
		this.numberCourse = numberCourse;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getCountStudents() {
		return countStudents;
	}
	public void setCountStudents(int countStudents) {
		this.countStudents = countStudents;
	}
	public int getLectureHours() {
		return lectureHours;
	}
	public void setLectureHours(int lectureHours) {
		this.lectureHours = lectureHours;
	}
	public int getPracticalHours() {
		return practicalHours;
	}
	public void setPracticalHours(int practicalHours) {
		this.practicalHours = practicalHours;
	}
	public int getLaborotoryHours() {
		return laborotoryHours;
	}
	public void setLaborotoryHours(int laborotoryHours) {
		this.laborotoryHours = laborotoryHours;
	}
	public boolean isCredit() {
		return credit;
	}
	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	public boolean isExam() {
		return exam;
	}
	public void setExam(boolean exam) {
		this.exam = exam;
	}
	public int getCountTests() {
		return countTests;
	}
	public void setCountTests(int countTests) {
		this.countTests = countTests;
	}
    public int getCountHours() {
    	return (int) Math.ceil((double)(this.lectureHours + this.practicalHours + this.laborotoryHours) 
    			+ (0.05 * this.lectureHours) + (this.exam ? 2 + (0.5 + this.countStudents) : 0) 
    			+ (this.credit ? (0.25 + this.countStudents) : 0)
    			+ (0.15 * this.countTests * this.countStudents));  
    }
    
}

