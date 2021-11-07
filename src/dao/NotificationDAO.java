package dao;

import java.util.List;

import entities.Notification;

public interface NotificationDAO {
	
	public List<Notification> getAllNotifications();
	public Notification getNotificationById(Integer stuId);
	public boolean insertNotification(Notification n);
	public boolean updateNotification(Notification n);
	public boolean deleteNotification(Integer stuId);

}
