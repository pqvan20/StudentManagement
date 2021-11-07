package entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "Stu_Id")
	private Integer stuId;
	@Column(name = "Stu_Name")
	private String fullName;
	@Column(name = "Stu_DOB")
	private Date stuDOB;
	@Column(name = "Stu_Gender")
	private boolean gender;
	@Column(name = "Stu_Phone")
	private int phone;
	@Column(name = "Stu_Mail")
	private String mail;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer stuId, String fullName, Date stuDOB, boolean gender, int phone, String mail) {
		super();
		this.stuId = stuId;
		this.fullName = fullName;
		this.stuDOB = stuDOB;
		this.gender = gender;
		this.phone = phone;
		this.mail = mail;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getStuDOB() {
		return stuDOB;
	}
	public void setStuDOB(Date stuDOB) {
		this.stuDOB = stuDOB;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}

