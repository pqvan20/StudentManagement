package entities;

	
	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "teacher")
	public class Teacher {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		@Column(name = "Te_Id")
		private int teId;
		@Column(name = "Te_Name")
		private String teName;
		@Column(name = "Te_DOB")
		private Date teDOB;
		@Column(name = "Te_Gender")
		private boolean teGender;
		@Column(name = "Te_Phone")
		private int tePhone;
		@Column(name = "Te_Mail")
		private String teMail;
		@Column(name = "Salary")
		private String salary;
		public Teacher() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Teacher(int teId, String teName, Date teDOB, boolean teGender, int tePhone, String teMail,
				String salary) {
			super();
			this.teId = teId;
			this.teName = teName;
			this.teDOB = teDOB;
			this.teGender = teGender;
			this.tePhone = tePhone;
			this.teMail = teMail;
			this.salary = salary;
		}
		public int getTeId() {
			return teId;
		}
		public void setTeId(int teId) {
			this.teId = teId;
		}
		public String getTeName() {
			return teName;
		}
		public void setTeName(String teName) {
			this.teName = teName;
		}
		public Date getTeDOB() {
			return teDOB;
		}
		public void setTeDOB(Date teDOB) {
			this.teDOB = teDOB;
		}
		public boolean isTeGender() {
			return teGender;
		}
		public void setTeGender(boolean teGender) {
			this.teGender = teGender;
		}
		public int getTePhone() {
			return tePhone;
		}
		public void setTePhone(int tePhone) {
			this.tePhone = tePhone;
		}
		public String getTeMail() {
			return teMail;
		}
		public void setTeMail(String teMail) {
			this.teMail = teMail;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
		
		
}
