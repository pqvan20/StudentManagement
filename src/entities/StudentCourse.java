package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SC_Id")
	private Integer scId;
	@JoinColumn(name="Stu_Id")
	@ManyToOne
	private Student stuId;
	@JoinColumn(name="C_Id")
	@ManyToOne
	private Course cId;
	@Column(name = "MidTerm_Mark")
	private Integer midTermMark;
	@Column(name = "Final_Mark")
	private Integer finalMark;
	@Column(name = "Attendance_Mark")
	private Integer attendanceMark; 
	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getScId() {
		return scId;
	}
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	public Student getStuId() {
		return stuId;
	}
	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}
	public Course getcId() {
		return cId;
	}
	public void setcId(Course cId) {
		this.cId = cId;
	}
	public Integer getMidTermMark() {
		return midTermMark;
	}
	public void setMidTermMark(Integer midTermMark) {
		this.midTermMark = midTermMark;
	}
	public Integer getFinalMark() {
		return finalMark;
	}
	public void setFinalMark(Integer finalMark) {
		this.finalMark = finalMark;
	}
	public Integer getAttendanceMark() {
		return attendanceMark;
	}
	public void setAttendanceMark(Integer attendanceMark) {
		this.attendanceMark = attendanceMark;
	}
	public StudentCourse(Integer scId, Student stuId, Course cId, Integer midTermMark, Integer finalMark,
			Integer attendanceMark) {
		super();
		this.scId = scId;
		this.stuId = stuId;
		this.cId = cId;
		this.midTermMark = midTermMark;
		this.finalMark = finalMark;
		this.attendanceMark = attendanceMark;
	}

}
