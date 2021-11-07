package controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CourseDAO;
import entities.Course;



@Controller
public class CourseController {
	private CourseDAO courseDAO;
	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	@RequestMapping("/listCourse")
	public String listCourse(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if(message!=null) {
			model.addAttribute("message", message);
		}
		List<Course> allCourses = courseDAO.getAllCourses();
		model.addAttribute("list", allCourses);
		return "Admin/Course/listCourses";
	} 
	
	@RequestMapping("/detailCourse")
	public String detailCourse(@RequestParam("cId")String cId, Model model) {
		Course c = courseDAO.getCourseById(cId);
		model.addAttribute("c", c);
		return "Admin/Course/courseDetail";
	}
	
	@RequestMapping("/initInsertC")        
	public String initInsertCourse(Model model) {
		model.addAttribute("c", new Course());
		return "Admin/Course/insertCourse";
	}
	
	@RequestMapping("/insertCourse")
	public String insertCourse(@ModelAttribute("c")Course c, Model model) {
	boolean bl = courseDAO.insertCourse(c);
	if(bl) {
		return "redirect:/listCourse?message=Insert successfully!";
	}else {
		model.addAttribute("error", "Insert failed!");
		model.addAttribute("c", c);
		return "Admin/Course/insertCourse";
	}
	}
	
	@RequestMapping("/initUpdateC")
	public String initUpdateCourse(@RequestParam("cId")String cId, Model model) {
		Course course = courseDAO.getCourseById(cId);
		model.addAttribute("c", course);
		return "Admin/Course/updateCourse";
	}
	
	@RequestMapping("/updateCourse")
	public String updateCourse(@ModelAttribute("c")Course c,Model model) {
		boolean bl = courseDAO.updateCourse(c);
		if(bl) {
			return "redirect:/listCourse?message=Update successfully!";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("c", c);
			return "Admin/Course/updateCourse";
		}
	}
	
	@RequestMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("cId")String cId, Model model) {
		boolean bl = courseDAO.deleteCourse(cId);
		String mess = "";
		if(bl) {
			mess = "Delete successfully!";
		}else {
			mess = "Delete failed!";
		}
		return "redirect:/listCourse?message="+mess;
	}
	
	@RequestMapping("/searchCourseById")
	public String searchCourseById( HttpServletRequest req,Model model) {
		
		String id = req.getParameter("id");
		Course course = courseDAO.getCourseById(id);
		model.addAttribute("c", course);
		return "Admin/Course/courseDetail";
	}
	
	@RequestMapping("/searchCoursesByName")
	public String searchCoursesByName(Model model, HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		String name = req.getParameter("name");
		List<Course> allCourses = courseDAO.getCoursesByName(name);
		model.addAttribute("list", allCourses);
		return "Admin/Course/listCourses";
	}
	
}
