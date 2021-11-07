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

import dao.NotificationDAO;
import entities.Notification;

@Controller
public class NotificationController {
	private NotificationDAO notificationDAO;
	@Autowired
	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	@RequestMapping("/listNotification")
	public String listNotification(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if(message!=null) {
			model.addAttribute("message", message);
		}
		List<Notification> allNotifications = notificationDAO.getAllNotifications();
		model.addAttribute("list", allNotifications);
		return "Admin/Notification/listNotifications";
	} 
	
	//for teacher
	@RequestMapping("/listTeacherNotification")
	public String listTeacherNotification(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if(message!=null) {
			model.addAttribute("message", message);
		}
		List<Notification> allNotifications = notificationDAO.getAllNotifications();
		model.addAttribute("list", allNotifications);
		return "Teacher/TeacherNotification";
	}
	
	
	@RequestMapping("/detailNotification")
	public String detailNotification(@RequestParam("notiId")Integer notiId, Model model) {
		Notification n = notificationDAO.getNotificationById(notiId);
		model.addAttribute("n", n);
		return "Admin/Notification/notificationDetail";
	}
	
	@RequestMapping("/initInsertN")
	public String initInsertNotification(Model model) {
		model.addAttribute("n", new Notification());
		return "Admin/Notification/insertNotification";
	}
	
	@RequestMapping("/insertNotification")
	public String insertNotification(@ModelAttribute("n")Notification n, Model model) {
	boolean bl = notificationDAO.insertNotification(n);
	if(bl) {
		return "redirect:/listNotification?message=Insert successfully!";
	}else {
		model.addAttribute("error", "Insert failed!");
		model.addAttribute("n", n);
		return "Admin/Notification/insertNotification";
	}
	}
	
	@RequestMapping("/initUpdateN")
	public String initUpdateNotification(@RequestParam("notiId")Integer notiId, Model model) {
		Notification notification = notificationDAO.getNotificationById(notiId);
		model.addAttribute("n", notification);
		return "Admin/Notification/updateNotification";
	}
	
	@RequestMapping("/updateNotification")
	public String updateNotification(@ModelAttribute("n")Notification n,Model model) {
		boolean bl = notificationDAO.updateNotification(n);
		if(bl) {
			return "redirect:/listNotification?message=Update successfully!";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("n", n);
			return "Admin/Notification/updateNotification";
		}
	}
	
	@RequestMapping("/deleteNotification")
	public String deleteNotification(@RequestParam("notiId")Integer notiId, Model model) {
		boolean bl = notificationDAO.deleteNotification(notiId);
		String mess = "";
		if(bl) {
			mess = "Delete successfully!";
		}else {
			mess = "Delete failed!";
		}
		return "redirect:/listNotification?message="+mess;
	}
}