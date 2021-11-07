package dao;

import java.util.List;

import entities.StudentCourse;

public interface StudentCourseDAO {
	public List<StudentCourse> getAllStudentCourses();
	public StudentCourse getStudentCourseById(Integer scId);
	public boolean insertStudentCourse(StudentCourse sc);
	public boolean updateStudentCourse(StudentCourse sc);
	public boolean deleteStudentCourse(Integer scId);
	public StudentCourse getStudentCourseByStuIdAndCId(Integer stuId, String cId);
	public List<StudentCourse> getStudentsByCourseId(String cId);
}
