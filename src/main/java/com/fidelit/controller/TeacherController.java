package com.fidelit.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fidelit.model.ChildProgress;
import com.fidelit.model.Exam;
import com.fidelit.model.ExamToSubject;
import com.fidelit.model.MessageBlog;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.GtsService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.TeacherService;

@Controller
@RequestMapping({ "/Teacher" })
public class TeacherController {

	@Autowired
	private SchoolAdminService schoolAdminService;

	@Autowired
	private GtsService gtsService;

	@Autowired
	RouteService routeService;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/home")
	public String userHome(ModelMap model) {

		model.addAttribute("homeActive", "homeActive");
		return "teacher_home";
	}

	@RequestMapping(value = "/ChildList")
	public String allStudentList(
			@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		System.out.println("In child list");
		HttpSession session = request.getSession();

		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);

		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");
		return "ChildList";

	}

	@RequestMapping(value = "/addMarks")
	public String AddMarks(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		
		ChildProgress cp= new ChildProgress();
		String ExamName = request.getParameter("ExamName");
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String date = request.getParameter("Date");
		String Subject = request.getParameter("Subject");
		int MinMarks = Integer.parseInt(request.getParameter("MinMarks"));
		int MaxMarks = Integer.parseInt(request.getParameter("MaxMarks"));
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		SchoolAdmin student=schoolAdminService.getSchoolAdminId(studentId);
		
		
		cp.setExamName(ExamName);
		cp.setDate(date);
		cp.setMaxMarks(MaxMarks);
		cp.setMinMarks(MinMarks);
		cp.setSubject(Subject);
		
	
		HttpSession session = request.getSession();

		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName1);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);

		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");
		return "ChildList";


	
		}
	
	@RequestMapping(value = "/addExam")
	public String addExam(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		
		Exam exam= new Exam();
		
		String examName = request.getParameter("examName");
		System.out.println("examName:"+examName);
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		int subjectNo = Integer.parseInt(request.getParameter("subjectNo"));
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		
		exam.setExamName(examName);
		exam.setDateFrom(dateFrom);
		exam.setDateTo(dateTo);
		exam.setSubjectNo(subjectNo);
		teacherService.addExam(exam);
	
		HttpSession session = request.getSession();

		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName1);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);

		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");
		request.setAttribute("subjects", exam.getSubjectNo());
		request.setAttribute("examIDD", exam.getExamId());
		return "AddSubjects";	
		}
	
	@RequestMapping(value = "/addSubject")
	public String addSubject(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		ExamToSubject ets = new ExamToSubject();
		int subjectNo = Integer.parseInt(request.getParameter("subjectNo"));
		int examIDD = Integer.parseInt(request.getParameter("examIDD"));
		String[] subArray = new String[subjectNo];
		int[] subMin = new int[subjectNo];
		int[] subMax = new int[subjectNo];
		
		for(int i=0; i<subjectNo; i++){
			subArray[i] = request.getParameter("subjectId"+i);
			subMin[i] = Integer.parseInt(request.getParameter("min"+i));
			subMax[i] = Integer.parseInt(request.getParameter("max"+i));
			if(i == 0){
				ets.setSubject1(subArray[0]);
				ets.setSubject1min(subMin[0]);
				ets.setSubject1max(subMax[0]);
			}
			if(i == 1){
				ets.setSubject2(subArray[1]);
				ets.setSubject2min(subMin[1]);
				ets.setSubject2max(subMax[1]);
			}
			if(i == 2){
				ets.setSubject3(subArray[2]);
				ets.setSubject3min(subMin[2]);
				ets.setSubject3max(subMax[2]);
			}
			if(i == 3){
				ets.setSubject4(subArray[3]);
				ets.setSubject4min(subMin[3]);
				ets.setSubject4max(subMax[3]);
			}
			if(i == 4){
				ets.setSubject5(subArray[4]);
				ets.setSubject5min(subMin[4]);
				ets.setSubject5max(subMax[4]);
			}
			if(i == 5){
				ets.setSubject6(subArray[5]);
				ets.setSubject6min(subMin[5]);
				ets.setSubject6max(subMax[5]);
			}
			if(i == 6){
				ets.setSubject7(subArray[6]);
				ets.setSubject7min(subMin[6]);
				ets.setSubject7max(subMax[6]);
			}
			if(i == 7){
				ets.setSubject8(subArray[7]);
				ets.setSubject8min(subMin[7]);
				ets.setSubject8max(subMax[7]);
			}
			if(i == 8){
				ets.setSubject9(subArray[8]);
				ets.setSubject9min(subMin[8]);
				ets.setSubject9max(subMax[8]);
			}
			if(i == 9){
				ets.setSubject10(subArray[9]);
				ets.setSubject10min(subMin[9]);
				ets.setSubject10max(subMax[9]);
			}
				
		
		}
		Exam exam = teacherService.getExamByExamId(examIDD);
		ets.setExam(exam);
		teacherService.addSubjectInExam(ets);

		HttpSession session = request.getSession();
		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName1);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		
		model.addAttribute("userName", username);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");

		
		return "ChildList";
	}
	
	@RequestMapping(value = "/addStudentMarks")
	public String addStudentMarks(@ModelAttribute("examObj") Exam examObj,HttpServletRequest request, HttpServletResponse response,ModelMap model){
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		request.setAttribute("studentId", studentId);
		List<Exam> exam = teacherService.getAllExam();
		model.addAttribute("examList", exam);
		return "StudentMarks";
	}
	
	
	@RequestMapping(value = "/examforstudent")
	public String examforstudent(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		String examId = request.getParameter("examName");
		int examID = Integer.parseInt(examId);
		String studentId =request.getParameter("studentId");
		int studentID = Integer.parseInt(studentId);
		System.out.println("examId:"+examId+"  studentId:"+studentId);
		ExamToSubject ets = teacherService.getExamToSubjectByExamId(examID);
		SchoolAdmin student = schoolAdminService.getSchoolAdminId(studentID);
		StudentToExam ste = new StudentToExam();
		Exam exam = teacherService.getExamByExamId(examID);
		boolean isUnique = teacherService.checkUniqueExamForStudent(examID, studentID);
		if(isUnique){
			StudentToExam studentToExam = teacherService.setStudentToExam(ste, ets, student, exam);
			model.addAttribute("studentToExam", studentToExam);
			request.setAttribute("studentToExamId", studentToExam.getId());
		}
		return "StudentMarksEnter";
	}
	

	@RequestMapping(value = "/addedMarksInStudent")
	public String addedMarksInStudent(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
	
		String studentToExamId = request.getParameter("studentToExamId");
		int Id = Integer.parseInt(studentToExamId);
		System.out.println("studentToExamID:"+Id);
		StudentToExam ste = teacherService.getStudentToExamById(Id);
		 request.getParameter("studentToExamId");
		if(ste.getSubject1() != null){
			int ob = Integer.parseInt(request.getParameter("subject1obtained"));
			ste.setSubject1obtained(ob);
		}
		if(ste.getSubject2() != null){
			int ob = Integer.parseInt(request.getParameter("subject2obtained"));
			ste.setSubject2obtained(ob);
		}
		if(ste.getSubject3() != null){
			int ob = Integer.parseInt(request.getParameter("subject3obtained"));
			ste.setSubject3obtained(ob);
		}
		if(ste.getSubject4() != null){
			int ob = Integer.parseInt(request.getParameter("subject4obtained"));
			ste.setSubject4obtained(ob);
		}
		if(ste.getSubject5() != null){
			int ob = Integer.parseInt(request.getParameter("subject5obtained"));
			ste.setSubject5obtained(ob);
		}
		if(ste.getSubject6() != null){
			int ob = Integer.parseInt(request.getParameter("subject6obtained"));
			ste.setSubject6obtained(ob);
		}
		if(ste.getSubject7() != null){
			int ob = Integer.parseInt(request.getParameter("subject7obtained"));
			ste.setSubject7obtained(ob);
		}
		if(ste.getSubject8() != null){
			int ob = Integer.parseInt(request.getParameter("subject8obtained"));
			ste.setSubject8obtained(ob);
		}
		if(ste.getSubject9() != null){
			int ob = Integer.parseInt(request.getParameter("subject9obtained"));
			ste.setSubject9obtained(ob);
		}
		if(ste.getSubject10() != null){
			int ob = Integer.parseInt(request.getParameter("subject10obtained"));
			ste.setSubject10obtained(ob);
		}
		
		teacherService.updateStudentToExam(ste);
		
		HttpSession session = request.getSession();
		SchoolAdmin currentUserr = (SchoolAdmin) session
				.getAttribute("currentUser");
		String userName1 = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList = schoolAdminService
				.getStudentList(userName1);
		model.addAttribute("schoolAdminList", schoolAdminList);
		List<School> schoolList = schoolService.allSchoolList(currentUserr
				.getAccountId());
		String username = currentUserr.getUsername();
		
		model.addAttribute("userName", username);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("childProgressActive", "childProgressActive");

		
		return "ChildList";
	}
	
	@RequestMapping(value = "/seeGraphs")
	public String seeGraphs(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int []minTotal = new int[10];
		int []maxTotal = new int[10];
		int []obtainedMarks= new int[10];
		List<StudentToExam> ste = teacherService.getStudentToExamByStudentId(studentId);
		int i=0;
		int []count= new int[10];
		String [] examNameArray = new String[ste.size()];
		for (StudentToExam sTOe : ste){
			minTotal[i]=sTOe.getSubject1min()+sTOe.getSubject2min()+sTOe.getSubject3min()+sTOe.getSubject4min()+sTOe.getSubject5min()+sTOe.getSubject6min()+sTOe.getSubject7min()+
					sTOe.getSubject8min()+sTOe.getSubject9min()+sTOe.getSubject10min();
			maxTotal[i]=sTOe.getSubject1max()+sTOe.getSubject2max()+sTOe.getSubject3max()+sTOe.getSubject4max()+sTOe.getSubject5max()+sTOe.getSubject6max()+sTOe.getSubject7max()+
					sTOe.getSubject8max()+sTOe.getSubject9max()+sTOe.getSubject10max();
			obtainedMarks[i]= sTOe.getSubject1obtained()+sTOe.getSubject2obtained()+sTOe.getSubject3obtained()+sTOe.getSubject4obtained()+sTOe.getSubject5obtained()+sTOe.getSubject6obtained()+sTOe.getSubject7obtained()+
					sTOe.getSubject8obtained()+sTOe.getSubject9obtained()+sTOe.getSubject10obtained();
			examNameArray[i]=sTOe.getExam().getExamName();
			i++;
		}
		for(int j=0;j<10;j++){
			count[j]=i;
		}
		int [] percentageArray = new int[ste.size()];
		
		
		for(int cnt=0;cnt<ste.size();cnt++){
			percentageArray[cnt]=(obtainedMarks[cnt]*100)/maxTotal[cnt];
		}
		
		for (int j = 0; j < percentageArray.length; j++) {
			System.out.println("percentage:"+percentageArray[j]);
		}
		request.setAttribute("values", percentageArray);
		request.setAttribute("lables", examNameArray);
		return "StudentMarksGraph";
		
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
		return "seeResults";
	}
	
	@RequestMapping(value = "/addMessageBlog")
	public String AddBlog(@ModelAttribute("messageBlog") MessageBlog blog,HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		String action = null;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		if(action != null){
			if(action.trim().equals("Add")){
				String userName1 = SecurityContextHolder.getContext()
					.getAuthentication().getName();
				SchoolAdmin teacher = schoolAdminService.getSchoolAdminByUsername(userName1);
				blog.setSchoolAdmin(teacher);   
				Date dateobj = new Date();
				
				blog.setBlogDate(dateobj);
				teacherService.addBlog(blog);	
			}	
		}
		List<MessageBlog> messageBlogList = teacherService.getMessageBlogList();
		model.addAttribute("messageBlogList",messageBlogList);
		model.addAttribute("messageBlog",new MessageBlog());
	    return "addMessageBlog";
	}
	
	@RequestMapping(value = "/AddBlog")
	public String blog(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
	
		return "AddBlog";
	}
	

	@RequestMapping(value = "/deleteBlogMessageList")
	public String deleteBlogMessageList(@RequestParam("blogMessageIdList") String str,HttpServletRequest request,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			teacherService.deleteBlogMessageById(id);
		}
		List<MessageBlog> messageBlogList = teacherService.getMessageBlogList();
		model.addAttribute("messageBlogList",messageBlogList);
		model.addAttribute("messageBlog",new MessageBlog());
		return "addMessageBlog";				
  }


	@RequestMapping(value = "/addFileBlog")
	public String AddFileBlog(@ModelAttribute("messageBlog") MessageBlog blog,HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
	    return "addFileBlog";
	}
}