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

import dao.StudentCourseDAO;
import entities.Student;
import entities.StudentCourse;

@Controller
public class StudentCourseController {
	private StudentCourseDAO studentCourseDAO;
	@Autowired
	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	@RequestMapping("/listStudentCourse")
	public String listStudentCourse(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if(message!=null) {
			model.addAttribute("message", message);
		}
		List<StudentCourse> allStudentCourses = studentCourseDAO.getAllStudentCourses();
		model.addAttribute("list", allStudentCourses);
		return "Admin/StudentCourse/listStudentCourses";
	} 
	
	@RequestMapping("/detailStudentCourse")
	public String detailStudentCourse(@RequestParam("scId")Integer scId, Model model) {
		StudentCourse sc = studentCourseDAO.getStudentCourseById(scId);
		model.addAttribute("sc", sc);
		return "Admin/StudentCourse/studentCourseDetail";
	}
	
	@RequestMapping("/initInsertSC")
	public String initInsertStudentCourse(Model model) {
		model.addAttribute("sc", new StudentCourse());
		return "Admin/StudentCourse/insertStudentCourse";
	}
	
	@RequestMapping("/insertStudentCourse")
	public String insertStudentCourse(@ModelAttribute("sc")StudentCourse sc, Model model) {
	boolean bl = studentCourseDAO.insertStudentCourse(sc);
	if(bl) {
		return "redirect:/listStudentCourse?message=Insert successfully!";
	}else {
		model.addAttribute("error", "Insert failed!");
		model.addAttribute("sc", sc);
		return "Admin/StudentCourse/insertStudentCourse";
	}
	}
	
	@RequestMapping("/initUpdateSC")
	public String initUpdateStudentCourse(@RequestParam("scId")Integer scId, Model model) {
		StudentCourse studentCourse = studentCourseDAO.getStudentCourseById(scId);
		model.addAttribute("sc", studentCourse);
		return "Admin/StudentCourse/updateStudentCourse";
	}
	
	@RequestMapping("/updateStudentCourse")
	public String updateStudentCourse(@ModelAttribute("sc")StudentCourse sc,Model model) {
		boolean bl = studentCourseDAO.updateStudentCourse(sc);
		if(bl) {
			return "redirect:/listStudentCourse?message=Update successfully!";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("sc", sc);
			return "Admin/StudentCourse/updateStudentCourse";
		}
	}
	
	@RequestMapping("/deleteStudentCourse")
	public String deleteStudentCourse(@RequestParam("scId")Integer scId, Model model) {
		boolean bl = studentCourseDAO.deleteStudentCourse(scId);
		String mess = "";
		if(bl) {
			mess = "Delete successfully!";
		}else {
			mess = "Delete failed!";
		}
		return "redirect:/listStudentCourse?message="+mess;
	}
	
	
	@RequestMapping("/searchStudentCourseById")
	public String searchStudentCourseById( HttpServletRequest req,Model model) {
		
		String id = req.getParameter("id");
		int stuId = Integer.parseInt(id);
		String cId = req.getParameter("cId");
		StudentCourse studentCourse = studentCourseDAO.getStudentCourseByStuIdAndCId(stuId, cId); // nó bảo lỗi ở đây
		model.addAttribute("sc", studentCourse);
		return "Admin/StudentCourse/studentCourseDetail";
	}
	
	@RequestMapping("/studentsInACourse")
	public String studentsInACourse(Model model, HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		String name = req.getParameter("name");
		List<StudentCourse> allStudentCourses = studentCourseDAO.getStudentsByCourseId(name);
		model.addAttribute("list", allStudentCourses);
		return "Admin/StudentCourse/listStudentCourses";
	}
	
	
	// for Students
	@RequestMapping("/searchStudentCourse_Student")
	public String searchStudentCourseForStudent( HttpServletRequest req,Model model) {
		
		String id = req.getParameter("id");
		int stuId = Integer.parseInt(id);
		String cId = req.getParameter("cId");
		StudentCourse studentCourse = studentCourseDAO.getStudentCourseByStuIdAndCId(stuId, cId);
		model.addAttribute("sc", studentCourse);
		return "Student/studentCourseDetail_Student";
	}
	
// for teachers
	
	@RequestMapping("/listStudentCourse_Teacher")
	public String listStudentCourseForTeacher(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if(message!=null) {
			model.addAttribute("message", message);
		}
		List<StudentCourse> allStudentCourses = studentCourseDAO.getAllStudentCourses();
		model.addAttribute("list", allStudentCourses);
		return "Teacher/listStudentCourses_Teacher";
	} 
	
	@RequestMapping("/detailStudentCourse_Teacher")
	public String detailStudentCourseForTeacher(@RequestParam("scId")Integer scId, Model model) {
		StudentCourse sc = studentCourseDAO.getStudentCourseById(scId);
		model.addAttribute("sc", sc);
		return "Teacher/studentCourseDetail_Teacher";
	}
	
	@RequestMapping("/initInsertSC_Teacher")
	public String initInsertStudentCourseForTeacher(Model model) {
		model.addAttribute("sc", new StudentCourse());
		return "Teacher/insertStudentCourse_Teacher";
	}
	
	@RequestMapping("/insertStudentCourse_Teacher")
	public String insertStudentCourseForTeacher(@ModelAttribute("sc")StudentCourse sc, Model model) {
	boolean bl = studentCourseDAO.insertStudentCourse(sc);
	if(bl) {
		return "redirect:/listStudentCourse_Teacher?message=Insert successfully!";
	}else {
		model.addAttribute("error", "Insert failed!");
		model.addAttribute("sc", sc);
		return "Teacher/insertStudentCourse_Teacher";
	}
	}
	
	@RequestMapping("/initUpdateSC_Teacher")
	public String initUpdateStudentCourseForTeacher(@RequestParam("scId")Integer scId, Model model) {
		StudentCourse studentCourse = studentCourseDAO.getStudentCourseById(scId);
		model.addAttribute("sc", studentCourse);
		return "Teacher/updateStudentCourse_Teacher";
	}
	
	@RequestMapping("/updateStudentCourse_Teacher")
	public String updateStudentCourseForTeacher(@ModelAttribute("sc")StudentCourse sc,Model model) {
		boolean bl = studentCourseDAO.updateStudentCourse(sc);
		if(bl) {
			return "redirect:/listStudentCourse_Teacher?message=Update successfully!";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("sc", sc);
			return "Teacher/updateStudentCourse_Teacher";
		}
	}
	
	@RequestMapping("/deleteStudentCourse_Teacher")
	public String deleteStudentCourseForTeacher(@RequestParam("scId")Integer scId, Model model) {
		boolean bl = studentCourseDAO.deleteStudentCourse(scId);
		String mess = "";
		if(bl) {
			mess = "Delete successfully!";
		}else {
			mess = "Delete failed!";
		}
		return "redirect:/listStudentCourse_Teacher?message="+mess;
	}
	
	@RequestMapping("/searchStudentCourse_Teacher")
	public String searchStudentCourseByIdForTeacher( HttpServletRequest req,Model model) {
		
		String id = req.getParameter("id");
		int stuId = Integer.parseInt(id);
		String cId = req.getParameter("cId");
		StudentCourse studentCourse = studentCourseDAO.getStudentCourseByStuIdAndCId(stuId, cId);
		model.addAttribute("sc", studentCourse);
		return "Teacher/studentCourseDetail_Teacher";
	}
	
	@RequestMapping("/studentsInACourse_Teacher")
	public String studentsInACourseForTeacher(Model model, HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		String cId = req.getParameter("name");
		List<StudentCourse> allStudentCourses = studentCourseDAO.getStudentsByCourseId(cId);
		model.addAttribute("list", allStudentCourses);
		return "Teacher/listStudentCourses_Teacher";
	}
	
	
}
