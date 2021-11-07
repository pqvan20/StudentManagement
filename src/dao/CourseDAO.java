package dao;

import java.util.List;

import entities.Course;

public interface CourseDAO {
	public List<Course> getAllCourses();
	public Course getCourseById(String cId);
	public boolean insertCourse(Course s);
	public boolean updateCourse(Course s);
	public boolean deleteCourse(String cId);
	public List<Course> getCoursesByName(String name);
	
}
