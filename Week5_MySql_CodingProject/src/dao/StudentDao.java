package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Student;

//class for manipulating data from the menu class

public class StudentDao {

	private Connection connection;
	private final String GET_STUDENTS_BY_ID_QUERY = "SELECT * FROM STUDENTS WHERE id = ?";
	private final String CREATE_NEW_STUDENT_QUERY = "INSERT INTO STUDENTS(first_name, last_name, grade) VALUES (?,?,?)";
	private final String DELETE_STUDENT_BY_ID_QUERY = "DELETE FROM STUDENTS WHERE id = ?";
	private final String UPDATE_STUDENT_BY_ID_QUERY = "UPDATE STUDENTS SET first_name = ?, last_name = ?, grade = ? WHERE id = ?";

	public StudentDao() {
		connection = DBConnection.getConnection();
	}

	public Student getStudentById(int id) throws SQLException {

		//method to execute read query
		PreparedStatement ps = connection.prepareStatement(GET_STUDENTS_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Student student = null;
		while (rs.next()) {
			student = new Student(id, rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return student;
	}

	//method to execute create query
	public void createNewStudent(String firstName, String lastName, String grade) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_STUDENT_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, grade);
		ps.executeUpdate();
	}

	//method to execute delete query 
	public void deleteStudentById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	//method to execute update query
	public void updateStudent(String firstName, String lastName, String grade, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT_BY_ID_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, grade);
		ps.setInt(4, id);
		ps.executeUpdate();
	}

}
