package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Account;

public class AccountDAOImpl implements AccountDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Account> getAllAccounts() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Account").list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public Account getAccountById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Account s = (Account) session.createQuery("from Account where id = :id").setParameter("id", id)
					.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertAccount(Account a) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(a);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(a);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Account where id= :id").setParameter("id", id)
					.executeUpdate();
			session.getTransaction().commit();
			session.close();
			if (i > 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	// validate
	@Override
	public boolean ifTeacher(String userName, String pass, boolean status) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Account a = (Account) session.createQuery("from Account A where A.user_name = :userName and status=0")
					.setParameter("userName", userName).uniqueResult();

			if (a != null && a.getPass().equals(pass)) {
				return true;
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean ifAdmin(String userName, String pass, boolean status) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Account a = (Account) session.createQuery("from Account A where A.user_name = :userName and status=1")
					.setParameter("userName", userName).uniqueResult();

			if (a != null && a.getPass().equals(pass)) {
				return true;
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}
}
