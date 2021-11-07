package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_Id")
	private String cId;
	@Column(name = "C_Name")
	private String cName;
	@Column(name = "Semester")
	private String semester;
	@JoinColumn(name="Te_Id")
	@ManyToOne
	private Teacher teId;
	@Column(name = "Cost")
	private String cost;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String cId, String cName, String semester, Teacher teId, String cost) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.semester = semester;
		this.teId = teId;
		this.cost = cost;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Teacher getTeId() {
		return teId;
	}

	public void setTeId(Teacher teId) {
		this.teId = teId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
	
	
	
	
	
	
	
	
}