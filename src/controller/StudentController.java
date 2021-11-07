package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StudentDAO;
import entities.Student;

@Controller
public class StudentController {
	private StudentDAO studentDAO;

	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping("/listStudent")
	public String listStudent(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		List<Student> allStudents = studentDAO.getAllStudents();
		model.addAttribute("list", allStudents);
		return "Admin/Student/listStudents";
	}

	@RequestMapping("/detailStudent")
	public String detailStudent(@RequestParam("stuId") Integer stuId, Model model) {
		Student s = studentDAO.getStudentById(stuId);
		model.addAttribute("s", s);
		return "Admin/Student/studentDetail";
	}

	@RequestMapping("/initInsertS")
	public String initInsertStudent(Model model) {
		model.addAttribute("s", new Student());
		return "Admin/Student/insertStudent";
	}

	@RequestMapping("/insertStudent")
	public String insertStudent(@ModelAttribute("s") Student s, Model model) {
		
		boolean bl = studentDAO.insertStudent(s);
		if (bl) {
			return "redirect:/listStudent?message=Insert successfully!";
		} else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("s", s);
			return "Admin/Student/insertStudent";
		}
	}

	@RequestMapping("/initUpdateS")
	public String initUpdateStudent(@RequestParam("stuId") Integer stuId, Model model) {
		Student student = studentDAO.getStudentById(stuId);
		model.addAttribute("s", student);
		return "Admin/Student/updateStudent";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("s") Student s, Model model) {
		boolean bl = studentDAO.updateStudent(s);
		if (bl) {
			return "redirect:/listStudent?message=Update successfully!";
		} else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("s", s);
			return "Admin/Student/updateStudent";
		}
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("stuId") Integer stuId, Model model) {
		boolean bl = studentDAO.deleteStudent(stuId);
		String mess = "";
		if (bl) {
			mess = "Delete successfully!";
		} else {
			mess = "Delete failed!";
		}
		return "redirect:/listStudent?message=" + mess;
	}

	@RequestMapping("/searchStudentById")
	public String searchStudentById(HttpServletRequest req, Model model) {

		String id = req.getParameter("id");
		int stuId = Integer.parseInt(id);
		Student student = studentDAO.getStudentById(stuId);
		model.addAttribute("s", student);
		return "Admin/Student/studentDetail";
	}

	@RequestMapping("/searchStudentsByName")
	public String searchStudentsByName(Model model, HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		String name = req.getParameter("name");
		List<Student> allStudents = studentDAO.getStudentsByName(name);
		model.addAttribute("list", allStudents);
		return "Admin/Student/listStudents";
	}


}
