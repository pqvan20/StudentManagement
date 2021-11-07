package dao;

import java.util.List;

import entities.Account;

public interface AccountDAO {
	public List<Account> getAllAccounts();
	public Account getAccountById(Integer id);
	public boolean insertAccount(Account s);
	public boolean updateAccount(Account s);
	public boolean deleteAccount(Integer id);
	public boolean ifAdmin(String userName,String pass,boolean status);
	public boolean ifTeacher(String userName,String pass,boolean status);
}
