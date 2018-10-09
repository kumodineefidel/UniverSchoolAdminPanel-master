package com.fidelit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Exam")
public class Exam {
	
	Integer examId;
	String  examName;
	String  dateFrom;
	String  dateTo;
	Integer subjectNo;
	List<SchoolAdmin> student;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="examId")
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	
	@Column(name="examName")
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	@Column(name="dateFrom")
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	@Column(name="dateTo")
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	@Column(name="subjectNo")
	public Integer getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(Integer subjectNo) {
		this.subjectNo = subjectNo;
	}
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="studentId",nullable = true, insertable = true, updatable = true)
	public List<SchoolAdmin> getStudent() {
		return student;
	}
	public void setStudent(List<SchoolAdmin> student) {
		this.student = student;
	}
		
}
