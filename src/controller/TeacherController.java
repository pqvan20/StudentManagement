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

import dao.TeacherDAO;
import entities.Teacher;

@Controller
public class TeacherController {
	private TeacherDAO teacherDAO;

	@Autowired
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping("/listTeacher")
	public String listTeacher(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		List<Teacher> allTeachers = teacherDAO.getAllTeachers();
		model.addAttribute("list", allTeachers);
		return "Admin/Teacher/listTeachers";
	}

	@RequestMapping("/detailTeacher")
	public String detailTeacher(@RequestParam("teId") Integer teId, Model model) {
		Teacher t = teacherDAO.getTeacherById(teId);
		model.addAttribute("t", t);
		return "Admin/Teacher/teacherDetail";
	}

	@RequestMapping("/initInsertT")
	public String initInsertTeacher(Model model) {
		model.addAttribute("t", new Teacher());
		return "Admin/Teacher/insertTeacher";
	}

	@RequestMapping("/insertTeacher")
	public String insertTeacher(@ModelAttribute("t") Teacher t, Model model) {
		boolean bl = teacherDAO.insertTeacher(t);
		if (bl) {
			return "redirect:/listTeacher?message=Insert successfully!";
		} else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("t", t);
			return "insertTeacher";
		}
	}

	@RequestMapping("/initUpdateT")
	public String initUpdateTeacher(@RequestParam("teId") Integer teId, Model model) {
		Teacher teacher = teacherDAO.getTeacherById(teId);
		model.addAttribute("t", teacher);
		return "Admin/Teacher/updateTeacher";
	}

	@RequestMapping("/updateTeacher")
	public String updateTeacher(@ModelAttribute("t") Teacher t, Model model) {
		boolean bl = teacherDAO.updateTeacher(t);
		if (bl) {
			return "redirect:/listTeacher?message=Update successfully!";
		} else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("t", t);
			return "Admin/Teacher/updateTeacher";
		}
	}

	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(@RequestParam("teId") Integer teId, Model model) {
		boolean bl = teacherDAO.deleteTeacher(teId);
		String mess = "";
		if (bl) {
			mess = "Delete successfully!";
		} else {
			mess = "Delete failed!";
		}
		return "redirect:/listTeacher?message=" + mess;
	}

	@RequestMapping("/searchTeacherById")
	public String search(HttpServletRequest req, Model model) {

		String id = req.getParameter("teId");
		int teId = Integer.parseInt(id);
		Teacher teacher = teacherDAO.getTeacherById(teId);
		model.addAttribute("t", teacher);
		return "Admin/Teacher/teacherDetail";
	}
	
	@RequestMapping("/searchTeachersByName")
	public String searchTeachersByName(Model model, HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		String name = req.getParameter("name");
		List<Teacher> allTeachers = teacherDAO.getTeachersByName(name);
		model.addAttribute("list", allTeachers);
		return "Admin/Teacher/listTeachers";
	}	

}
