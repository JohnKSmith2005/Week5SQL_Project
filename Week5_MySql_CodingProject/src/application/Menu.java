package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class Menu {
	
	// Menu class - prints options and allows user to Create, Read, Update and Delete data
	private StudentDao studentDao = new StudentDao();
	private Scanner scanner = new Scanner(System.in);
	
	// Create array of options
	private List<String> options = Arrays.asList("Display a Student", 
			"Create Student", "Delete Student", "Update Student");

	public void start() {
		// Selection string determines menu option, defaults to blank.
		String selection = "";
		// create a loop to continue program until it's exited.
		do {
			printMenu();
			selection = scanner.nextLine();

			try {
				if (selection.equals("1")) {
					displayStudent();
				} else if (selection.equals("2")) {
					createStudent();
				} else if (selection.equals("3")) {
					deleteStudent();
				} else if (selection.equals("4")) {
					updateStudent();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// else if is used to avoid selection an option if nothing is valid.

			System.out.println("Press enter to continue....");
			scanner.nextLine(); // holds the program until enter is pressed.

		} while (!selection.equals("-1"));
	}

	// Method to UPDATE data
	private void updateStudent() throws SQLException {
		System.out.print("Enter ID of student:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new first name of new student:");
		String firstName = scanner.nextLine();
		System.out.print("Enter new last name of new student:");
		String lastName = scanner.nextLine();
		System.out.print("Enter new grade for new student:");
		String grade = scanner.nextLine();
		studentDao.updateStudent(firstName, lastName, grade, id);
	}


	// Method to print the opening menu.
	private void printMenu() {
		System.out.println("Select an Option, type -1 to exit:\n--------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

	//Method to READ data
	private void displayStudent() throws SQLException {
		System.out.print("Enter student id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Student student = studentDao.getStudentById(id);
		//Checks given ID after student is returned to make sure it is not null.
		if (student == null) {
			System.out.println("Invalid selection, given student ID is null.");
		} else {
			System.out.println("StudentId: " + student.getid() + " - Name: " + student.getFirstName() + " "
					+ student.getLastName() + " - Grade:" + student.getGrade());
		}
	}

	//Method to CREATE data
	private void createStudent() throws SQLException {
		System.out.print("Enter first name of new student:");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name of new student:");
		String lastName = scanner.nextLine();
		System.out.print("Enter grade for new student:");
		String grade = scanner.nextLine();
		studentDao.createNewStudent(firstName, lastName, grade);
	}

	//Method to DELETE data
	private void deleteStudent() throws SQLException {
		System.out.println("Enter student id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		studentDao.deleteStudentById(id);
	}

}
