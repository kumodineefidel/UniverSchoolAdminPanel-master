package com.fidelit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.MessageBlog;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.StudentService;
import com.fidelit.service.TeacherService;

@Controller
@RequestMapping({"/student"})
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolAdminService schoolAdminService;
	
	@RequestMapping("/home")
	public String adminHome(){
		
		return "student_home";
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@RequestMapping(value = "/seeBlogs")
	public String seeBlogs(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		SchoolAdmin student = schoolAdminService.getSchoolAdminByUsername(userName1);
		String studentClass = student.getStudentClass();
		List<MessageBlog> blogs = studentService.getBlogsByClass(studentClass);
		
		model.addAttribute("blogs", blogs);
		return "seeBlogs";
	}

}
