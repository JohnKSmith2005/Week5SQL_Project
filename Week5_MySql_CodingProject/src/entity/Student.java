package entity;

public class Student {

	// Class to define students

	private int id;
	private String firstName;
	private String lastName;
	private String grade;

	public Student(int id, String firstName, String lastName, String grade) {
		this.setid(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGrade(grade);
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
