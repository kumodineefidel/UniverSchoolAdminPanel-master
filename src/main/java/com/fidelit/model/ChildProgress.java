package com.fidelit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name = "ChildProgress")
public class ChildProgress {

	private Integer cId;
	private String ExamName;
	private String Date;
	private String Subject;
	private Integer MinMarks;
	private Integer MaxMarks;
	private List<SchoolAdmin> Schooladmin;

	@ManyToMany(mappedBy = "")
	public List<SchoolAdmin> getSchooladmin() {
		return Schooladmin;
	}

	public void setSchooladmin(List<SchoolAdmin> schooladmin) {
		Schooladmin = schooladmin;
	}

	public String getExamName() {
		return ExamName;
	}

	public void setExamName(String examName) {
		ExamName = examName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Integer getMinMarks() {
		return MinMarks;
	}

	public void setMinMarks(Integer minMarks) {
		MinMarks =minMarks;
	}

	public Integer getMaxMarks() {
		return MaxMarks;
	}

	public void setMaxMarks(Integer maxMarks) {
		MaxMarks = maxMarks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cId")
	public Integer getCid() {
		return cId;
	}

	public void setCid(Integer cid) {
		this.cId = cid;
	}

}
