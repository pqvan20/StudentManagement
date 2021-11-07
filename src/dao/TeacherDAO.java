package dao;

import java.util.List;

import entities.Teacher;

public interface TeacherDAO {
	public List<Teacher> getAllTeachers();
	public Teacher getTeacherById(Integer teId);
	public boolean insertTeacher(Teacher s);
	public boolean updateTeacher(Teacher s);
	public boolean deleteTeacher(Integer teId);
	public List<Teacher> getTeachersByName(String name);
}
