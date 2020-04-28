package by.vsu.teacher;

import java.sql.Date;

import by.vsu.course.Courses;

public class Teacher {
	private Integer id;
	private String name;
	private String surname;
	private String patronymic;
	private String sex;
	private int position;
	private int degree;
    private Date birthday;

    public String getFullName() {
    	return this.surname + " " + this.name.toUpperCase().substring(0, 1) + ". " + this.name.toUpperCase().substring(0, 1)+".";
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int possition) {
		this.position = possition;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getCountCourse() {
		return Courses.getCoursesForTeacher(this.id).size();
	}
}

