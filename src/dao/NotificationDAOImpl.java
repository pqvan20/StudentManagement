package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Notification;

public class NotificationDAOImpl implements NotificationDAO{
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Notification> getAllNotifications() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Notification").list();
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
	public Notification getNotificationById(Integer notiId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Notification n = (Notification) session.createQuery("from Notification where notiId = :notiId").setParameter("notiId", notiId)
					.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return n;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertNotification(Notification n) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(n);
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
	public boolean updateNotification(Notification n) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(n);
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
	public boolean deleteNotification(Integer notiId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Notification where notiId= :notiId").setParameter("notiId", notiId)
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

}
