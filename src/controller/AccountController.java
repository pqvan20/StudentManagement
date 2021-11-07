package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AccountDAO;
import entities.Account;

@Controller
public class AccountController {
	private AccountDAO accountDAO;

	@Autowired
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping("/listAccount")
	public String listAccount(Model model, HttpServletRequest request) {
		String message = request.getParameter("message");
		if (message != null) {
			model.addAttribute("message", message);
		}
		List<Account> allAccounts = accountDAO.getAllAccounts();
		model.addAttribute("list", allAccounts);
		return "Admin/Account/listAccounts";
	}

	@RequestMapping("/detailAccount")
	public String detailAccount(@RequestParam("id") Integer id, Model model) {
		Account a = accountDAO.getAccountById(id);
		model.addAttribute("a", a);
		return "Admin/Account/accountDetail";
	}

	@RequestMapping("/initInsertA")
	public String initInsertAccount(Model model) {
		model.addAttribute("a", new Account());
		return "Admin/Account/insertAccount";
	}

	@RequestMapping("/insertAccount")
	public String insertAccount(@ModelAttribute("a") Account a, Model model) {
		boolean bl = accountDAO.insertAccount(a);
		if (bl) {
			return "redirect:/listAccount?message=Insert successfully!";
		} else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("a", a);
			return "Admin/Account/insertAccount";
		}
	}

	@RequestMapping("/initUpdateA")
	public String initUpdateAccount(@RequestParam("id") Integer id, Model model) {
		Account account = accountDAO.getAccountById(id);
		model.addAttribute("a", account);
		return "Admin/Account/updateAccount";
	}

	@RequestMapping("/updateAccount")
	public String updateAccount(@ModelAttribute("a") Account a, Model model) {
		boolean bl = accountDAO.updateAccount(a);
		if (bl) {
			return "redirect:/listAccount?message=Update successfully!";
		} else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("a", a);
			return "Admin/Account/updateAccount";
		}
	}

	@RequestMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("id") Integer id, Model model) {
		boolean bl = accountDAO.deleteAccount(id);
		String mess = "";
		if (bl) {
			mess = "Delete successfully!";
		} else {
			mess = "Delete failed!";
		}
		return "redirect:/listAccount?message=" + mess;
	}

// login
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");

		if (accountDAO.ifTeacher(username, pass, false)) {
			return "redirect:/listTeacherNotification";
		}else if(accountDAO.ifAdmin(username, pass, true)) {
			return "redirect:/listNotification";
		}
		
		
		else {
			model.addAttribute("fail", "user name or password is wrong !!");
			return "login";
		}

	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}


}
