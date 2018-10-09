package com.fidelit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message_blog")
public class MessageBlog {

	
	private int blogId;
	
	private String message;
	
	private String studentClass;
	
	private Date blogDate;
	
    private SchoolAdmin schoolAdmin;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)  
	public SchoolAdmin getSchoolAdmin() {
		return schoolAdmin;
	}
	public void setSchoolAdmin(SchoolAdmin schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	
	public String getStudentClass() {
		return studentClass;
	}
	
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public Date getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
}
