package entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="notification")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "Noti_Id")
	private Integer notiId;
	@Column(name= "Date")
	private Date notiDate;
	@Column(name = "Notification")
	private String notification;
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(Integer notiId, Date notiDate, String notification) {
		super();
		this.notiId = notiId;
		this.notiDate = notiDate;
		this.notification = notification;
	}
	public Integer getNotiId() {
		return notiId;
	}
	public void setNotiId(Integer notiId) {
		this.notiId = notiId;
	}
	public Date getNotiDate() {
		return notiDate;
	}
	public void setNotiDate(Date notiDate) {
		this.notiDate = notiDate;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	
	
	
	
	

}
