package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entities.StudentCourse;

public class StudentCourseDAOImpl implements StudentCourseDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<StudentCourse> getAllStudentCourses() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from StudentCourse").list();
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
	public StudentCourse getStudentCourseById(Integer scId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			StudentCourse sc = (StudentCourse) session.createQuery("from StudentCourse where scId = :scId")
					.setParameter("scId", scId).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return sc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertStudentCourse(StudentCourse sc) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(sc);
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
	public boolean updateStudentCourse(StudentCourse sc) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(sc);
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
	public boolean deleteStudentCourse(Integer scId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from StudentCourse where scId= :scId").setParameter("scId", scId)
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

	@Override
	public StudentCourse getStudentCourseByStuIdAndCId(Integer stuId, String cId) {
		Session session = sessionFactory.openSession();
		try {
			
			session.beginTransaction();
			StudentCourse sc = (StudentCourse) session.createQuery("from StudentCourse  where stuId.stuId = :stuId and cId.cId = :cId")
					.setParameter("stuId", stuId).setParameter("cId", cId).uniqueResult(); 
			session.getTransaction().commit();
			session.close();
			return sc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}
	
	@Override
	public List<StudentCourse> getStudentsByCourseId(String cId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from StudentCourse where cId.cId = :cId").setParameter("cId", cId).list();
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

}
