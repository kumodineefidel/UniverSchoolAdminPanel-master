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
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="StudentToExam")
public class StudentToExam {
	
	int Id;
	
	String  subject1;
	int subject1min;
    int subject1max;
    int subject1obtained;
	
    String  subject2;
	int subject2min;
	int subject2max;
	int subject2obtained;
	
	String  subject3;
	int subject3min;
	int subject3max;
	int subject3obtained;
	
	String  subject4;
	int subject4min;
	int subject4max;
	int subject4obtained;
	
	String  subject5;
	int subject5min;
	int subject5max;
	int subject5obtained;
	
	String  subject6;
	int subject6min;
	int subject6max;
	int subject6obtained;
	
	String  subject7;
	int subject7min;
	int subject7max;
	int subject7obtained;
	
	String  subject8;
	int subject8min;
	int subject8max;
	int subject8obtained;
	
	String  subject9;
	int subject9min;
	int subject9max;
	int subject9obtained;
	
	String  subject10;
	int subject10min;
	int subject10max;
	int subject10obtained;
	
	Exam exam;
	
	SchoolAdmin student;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public int getSubject1obtained() {
		return subject1obtained;
	}
	public void setSubject1obtained(int subject1obtained) {
		this.subject1obtained = subject1obtained;
	}
	
	public int getSubject2obtained() {
		return subject2obtained;
	}
	public void setSubject2obtained(int subject2obtained) {
		this.subject2obtained = subject2obtained;
	}
	
	public int getSubject3obtained() {
		return subject3obtained;
	}
	public void setSubject3obtained(int subject3obtained) {
		this.subject3obtained = subject3obtained;
	}
	
	public int getSubject4obtained() {
		return subject4obtained;
	}
	public void setSubject4obtained(int subject4obtained) {
		this.subject4obtained = subject4obtained;
	}
	
	public int getSubject5obtained() {
		return subject5obtained;
	}
	public void setSubject5obtained(int subject5obtained) {
		this.subject5obtained = subject5obtained;
	}
	
	public int getSubject6obtained() {
		return subject6obtained;
	}
	public void setSubject6obtained(int subject6obtained) {
		this.subject6obtained = subject6obtained;
	}
	
	public int getSubject7obtained() {
		return subject7obtained;
	}
	public void setSubject7obtained(int subject7obtained) {
		this.subject7obtained = subject7obtained;
	}
	
	public int getSubject8obtained() {
		return subject8obtained;
	}
	public void setSubject8obtained(int subject8obtained) {
		this.subject8obtained = subject8obtained;
	}
	
	public int getSubject9obtained() {
		return subject9obtained;
	}
	public void setSubject9obtained(int subject9obtained) {
		this.subject9obtained = subject9obtained;
	}
	
	public int getSubject10obtained() {
		return subject10obtained;
	}
	public void setSubject10obtained(int subject10obtained) {
		this.subject10obtained = subject10obtained;
	}
	
	@Required
	@OneToOne(cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="examId",nullable = true, insertable = true, updatable = true)
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	@Required
	@OneToOne(cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="studentId",nullable = true, insertable = true, updatable = true)
	public SchoolAdmin getStudent() {
		return student;
	}
	public void setStudent(SchoolAdmin student) {
		this.student = student;
	}
	
	public int getSubject1min() {
		return subject1min;
	}
	public void setSubject1min(int subject1min) {
		this.subject1min = subject1min;
	}
	
	public int getSubject1max() {
		return subject1max;
	}
	public void setSubject1max(int subject1max) {
		this.subject1max = subject1max;
	}
	
	public int getSubject2min() {
		return subject2min;
	}
	public void setSubject2min(int subject2min) {
		this.subject2min = subject2min;
	}
	
	public int getSubject2max() {
		return subject2max;
	}
	public void setSubject2max(int subject2max) {
		this.subject2max = subject2max;
	}
	
	public int getSubject3min() {
		return subject3min;
	}
	public void setSubject3min(int subject3min) {
		this.subject3min = subject3min;
	}
	
	public int getSubject3max() {
		return subject3max;
	}
	public void setSubject3max(int subject3max) {
		this.subject3max = subject3max;
	}
	
	public int getSubject4min() {
		return subject4min;
	}
	public void setSubject4min(int subject4min) {
		this.subject4min = subject4min;
	}
	
	public int getSubject4max() {
		return subject4max;
	}
	public void setSubject4max(int subject4max) {
		this.subject4max = subject4max;
	}
	
	public int getSubject5min() {
		return subject5min;
	}
	public void setSubject5min(int subject5min) {
		this.subject5min = subject5min;
	}
	
	public int getSubject5max() {
		return subject5max;
	}
	public void setSubject5max(int subject5max) {
		this.subject5max = subject5max;
	}
	
	public int getSubject6min() {
		return subject6min;
	}
	public void setSubject6min(int subject6min) {
		this.subject6min = subject6min;
	}
	
	public int getSubject6max() {
		return subject6max;
	}
	public void setSubject6max(int subject6max) {
		this.subject6max = subject6max;
	}
	
	public int getSubject7min() {
		return subject7min;
	}
	public void setSubject7min(int subject7min) {
		this.subject7min = subject7min;
	}
	
	public int getSubject7max() {
		return subject7max;
	}
	public void setSubject7max(int subject7max) {
		this.subject7max = subject7max;
	}
	
	public int getSubject8min() {
		return subject8min;
	}
	public void setSubject8min(int subject8min) {
		this.subject8min = subject8min;
	}
	
	public int getSubject8max() {
		return subject8max;
	}
	public void setSubject8max(int subject8max) {
		this.subject8max = subject8max;
	}
	
	public int getSubject9min() {
		return subject9min;
	}
	public void setSubject9min(int subject9min) {
		this.subject9min = subject9min;
	}
	
	public int getSubject9max() {
		return subject9max;
	}
	public void setSubject9max(int subject9max) {
		this.subject9max = subject9max;
	}
	
	public int getSubject10min() {
		return subject10min;
	}
	public void setSubject10min(int subject10min) {
		this.subject10min = subject10min;
	}
	
	public int getSubject10max() {
		return subject10max;
	}
	public void setSubject10max(int subject10max) {
		this.subject10max = subject10max;
	}
	
	
	@Column(name="subject1")
	public String getSubject1() {
		return subject1;
	}
	
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	
	@Column(name="subject2")
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	
	@Column(name="subject3")
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	
	@Column(name="subject4")
	public String getSubject4() {
		return subject4;
	}
	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}
	
	@Column(name="subject5")
	public String getSubject5() {
		return subject5;
	}
	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}
	
	@Column(name="subject6")
	public String getSubject6() {
		return subject6;
	}
	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}
	
	@Column(name="subject7")
	public String getSubject7() {
		return subject7;
	}
	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}
	
	@Column(name="subject8")
	public String getSubject8() {
		return subject8;
	}
	public void setSubject8(String subject8) {
		this.subject8 = subject8;
	}
	
	@Column(name="subject9")
	public String getSubject9() {
		return subject9;
	}
	public void setSubject9(String subject9) {
		this.subject9 = subject9;
	}
	
	@Column(name="subject10")
	public String getSubject10() {
		return subject10;
	}
	public void setSubject10(String subject10) {
		this.subject10 = subject10;
	}
	
	
	
}
