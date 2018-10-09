package com.fidelit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.MessageBlog;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.ParentService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.StudentService;
import com.fidelit.service.TeacherService;

@Controller
@RequestMapping({"/parent"})
public class ParentController {
	
	@Autowired
	private SchoolAdminService schoolAdminService;
	
	@Autowired
	private ParentService parentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/ChildList")
	public String ChildList(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
			SchoolAdmin parent = schoolAdminService.getSchoolAdminByUsername(userName1);
		int parentId = parent.getId();
		System.out.println("parentId"+parentId);
		List<SchoolAdmin> studentList = parentService.getChildrenByParentId(parentId);
		model.addAttribute("studentList", studentList);
		return "ParentToChildList";
		
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		return "parent_home";
	}
	
	@RequestMapping(value = "/seeResults")
	public String seeResults(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int []minTotal = new int[10];
		int []maxTotal = new int[10];
		int []obtainedMarks= new int[10];
		List<StudentToExam> ste = teacherService.getStudentToExamByStudentId(studentId);
		int i=0;
		int []count= new int[10];
		for (StudentToExam sTOe : ste){
			minTotal[i]=sTOe.getSubject1min()+sTOe.getSubject2min()+sTOe.getSubject3min()+sTOe.getSubject4min()+sTOe.getSubject5min()+sTOe.getSubject6min()+sTOe.getSubject7min()+
					sTOe.getSubject8min()+sTOe.getSubject9min()+sTOe.getSubject10min();
			maxTotal[i]=sTOe.getSubject1max()+sTOe.getSubject2max()+sTOe.getSubject3max()+sTOe.getSubject4max()+sTOe.getSubject5max()+sTOe.getSubject6max()+sTOe.getSubject7max()+
					sTOe.getSubject8max()+sTOe.getSubject9max()+sTOe.getSubject10max();
			obtainedMarks[i]= sTOe.getSubject1obtained()+sTOe.getSubject2obtained()+sTOe.getSubject3obtained()+sTOe.getSubject4obtained()+sTOe.getSubject5obtained()+sTOe.getSubject6obtained()+sTOe.getSubject7obtained()+
					sTOe.getSubject8obtained()+sTOe.getSubject9obtained()+sTOe.getSubject10obtained();
			i++;
		}
		for(int j=0;j<10;j++){
			count[j]=i;
		}
		model.addAttribute("counts", count);
		model.addAttribute("obtainedMarks", obtainedMarks);
		model.addAttribute("maxTotal", maxTotal);
		model.addAttribute("minTotal", minTotal);
		model.addAttribute("StudentToExam", ste);
		return "seeResultsForParent";
	}
	
	@RequestMapping(value = "/seeBlogs")
	public String seeBlogs(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		SchoolAdmin student = schoolAdminService.getSchoolAdminId(studentId);
		String studentClass = student.getStudentClass();
		List<MessageBlog> blogs = studentService.getBlogsByClass(studentClass);
		
		model.addAttribute("blogs", blogs);
		return "seeBlogsForParent";
	}
}
