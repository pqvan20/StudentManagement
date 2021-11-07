package dao;

import java.util.List;

import entities.Student;



public interface StudentDAO {
	public List<Student> getAllStudents();
	public Student getStudentById(Integer stuId);
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Integer stuId);
	public List<Student> getStudentsByName(String name);
}
