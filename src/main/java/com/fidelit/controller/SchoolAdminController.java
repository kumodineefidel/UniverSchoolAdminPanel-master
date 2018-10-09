package com.fidelit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Filters;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fidelit.model.Employee;
import com.fidelit.model.Holidays;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.ParentToStudent;
import com.fidelit.model.Route;
import com.fidelit.model.RouteToStudent;
import com.fidelit.model.School;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.SuperVisor;
import com.fidelit.model.empLeavesTaken;
import com.fidelit.service.EmployeeService;
import com.fidelit.service.GtsService;
import com.fidelit.service.HolidayService;
import com.fidelit.service.LeaveService;
import com.fidelit.service.RouteService;
import com.fidelit.service.SchoolAdminService;
import com.fidelit.service.SchoolService;
import com.fidelit.service.UserService;


@Controller
@RequestMapping({"/schoolAdmin"})
public class SchoolAdminController {
	
	@Autowired	
	private SchoolService schoolService;
	
	@Autowired
	private SchoolAdminService schoolAdminService;
	
	@Autowired	
    private GtsService gtsService;
	
	@Autowired
	RouteService routeService;
	
	@RequestMapping(value="/home" )
	public String userHome(ModelMap model){
		
		model.addAttribute("homeActive", "homeActive");
		return "schoolAdminHome";
	}
	
	@RequestMapping(value="/parentList")
	public String allParentList(@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
		
		
		
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		int[] StudentId= new int[30];
		System.out.println("Action:"+action);
		if(action.equals("add")){
			 String student1=request.getParameter("student1");
	            String[] student2=student1.split(",");
	            String[] studentNo=new String[30];
	 
			System.out.println("Add Controller");
			 schoolAdmin.setRole("ROLE_PARENT");
				School school=schoolService.getSchool(schoolAdmin.getSchool().getSchoolName());
				schoolAdmin.setEnabled(true);
				gtsService.addAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
				
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				schoolAdmin.setAccountId(userName);
			//	schoolAdmin.setSchool(school);
				schoolAdmin.setAccountType("Parent");
				schoolAdminService.addSchoolAdmin(schoolAdmin);
				
                int parentId= schoolAdminService.getLastSchoolAdminId();
                
                for(int i=0;i<student2.length;i++){
                    studentNo=student2[i].split("-");
                    for(int j=0;j<studentNo.length;j++)
                    {
                        if(j==0){
                            
                            System.out.println(studentNo[j]);
                            StudentId[j]=Integer.parseInt(studentNo[j]);
                            SchoolAdmin schoolAdminn = schoolAdminService.getParentId(StudentId[j]);//This give student
                            schoolAdminn.setUsed(true);
                            schoolAdminService.updateSchoolAdmin(schoolAdminn);
                            schoolAdminService.addParentToStudent(schoolAdminn, parentId);
                            List<SchoolAdmin> routes= schoolAdminService.getAllParentToStudent(parentId);
                        }
                    }
                }
				
				model.addAttribute("success", "success");
				model.addAttribute(new SchoolAdmin());
				
		}
		
		if(action.equals("edit")){
			//	School school =schoolAdmin.getSchool();
				schoolAdmin.setAccountType("Parent");
				model.addAttribute(new SchoolAdmin());
				schoolAdmin.setRole("ROLE_PARENT");
				schoolAdmin.setEnabled(true);
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				schoolAdmin.setAccountId(userName);
			//	schoolAdmin.setSchool(school);
				model.addAttribute("edit", "edit");
				schoolAdminService.updateSchoolAdmin(schoolAdmin);
				
			}
		
		HttpSession session = request.getSession();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		System.out.println("currentUser"+currentUser.getAccountId());
		List<School> schoolList=schoolService.allSchoolList(currentUser.getUsername());
		System.out.println("schoolList:"+schoolList.toString());
		for (School school : schoolList) {
			System.out.println("schoolList:"+school.toString());
		}
		
		
		SchoolAdmin currentUserr = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);
		List<SchoolAdmin> studentList = schoolAdminService.getAllStudentListForParent(username);
		List<SchoolAdmin> studentListForDisplay=schoolAdminService.getAllStudentList(username);
		List<ParentToStudent> parentToStudentList=schoolAdminService.getAllParentToStudentList();
		for(ParentToStudent parantsToStudent : parentToStudentList){
			System.out.println("ParentTOStudentId :"+parantsToStudent.getId());
		}
		model.addAttribute("studentListForDisplay",studentListForDisplay);
		model.addAttribute("parentToStudentList",parentToStudentList);
	    model.addAttribute("studentList", studentList);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("parentActive", "parentActive");
		return "parentList";
	}
	
	@RequestMapping(value = "/uniqueUsername")
	@ResponseBody
	public JSONObject UniqueUsername(HttpServletResponse response,
	        @RequestParam String username) throws IOException {
		
		JSONObject isUnique= new JSONObject();
		System.out.println("username:" + username);
	    boolean isUnique1= schoolAdminService.getUniqueUserName(username);
	    if(isUnique1==true)
	    	isUnique1=false;
	    else
	    	isUnique1=true;
	    isUnique.put("valid", isUnique1);
	    System.out.println("IsUniques :"+ isUnique);
	    return isUnique;
	}
	
	@RequestMapping(value = "/uniqueUsernameforEdit")
	@ResponseBody
	public JSONObject UniqueUsernameforEdit(HttpServletRequest request,HttpServletResponse response,
	        @RequestParam String username) throws IOException {
		
		
		String id=request.getParameter("adminId");
		System.out.println("ID"+id);
		JSONObject isUnique= new JSONObject();
		System.out.println("username:" + username);
		System.out.println("ID:" + id);
		SchoolAdmin admin=schoolAdminService.getSchoolAdminId(Integer.parseInt(id));
		System.out.println("admin.getName() :"+admin.getName());
		if(admin.getUsername().equals(username)){
			isUnique.put("valid", true);
		}else{
			boolean isUnique1= schoolAdminService.getUniqueUserName(username);
			if(isUnique1==true)
				isUnique1=false;
			else
				isUnique1=true;
			isUnique.put("valid", isUnique1);
			System.out.println("IsUniques :"+ isUnique);
		}
	    return isUnique;
		
	}	
	
	@RequestMapping(value="/TeacherList")
	public String allTeacherList(@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws ParseException{
	
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action:"+action);
		if(action.equals("add")){
			
	 
			System.out.println("Add Controller");
			 schoolAdmin.setRole("ROLE_TEACHER");
			 schoolAdmin.setAccountType("Teacher");
				School school=schoolService.getSchool(schoolAdmin.getSchool().getSchoolName());
				schoolAdmin.setEnabled(true);
				gtsService.addAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
				
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				schoolAdmin.setAccountId(userName);
				schoolAdmin.setAccountType("Teacher");
				schoolAdminService.addSchoolAdmin(schoolAdmin);	
				model.addAttribute("success", "success");
				model.addAttribute(new SchoolAdmin());
				
		}
		
		if(action.equals("edit")){
				System.out.println("IN Teacher Edit");
				System.out.println("Teacher ID:"+schoolAdmin.getAccountId());
				schoolAdmin.setAccountType("Teacher");
				model.addAttribute(new SchoolAdmin());
				schoolAdmin.setRole("ROLE_TEACHER");
				schoolAdmin.setEnabled(true);
				String userName = SecurityContextHolder.getContext().getAuthentication().getName();
				schoolAdmin.setAccountId(userName);
				model.addAttribute("edit", "edit");
				schoolAdminService.updateSchoolAdmin(schoolAdmin);
				
			}
		
		HttpSession session = request.getSession();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		System.out.println("currentUser"+currentUser.getAccountId());
		List<School> schoolList=schoolService.allSchoolList(currentUser.getUsername());
		System.out.println("schoolList:"+schoolList.toString());
		for (School school : schoolList) {
			System.out.println("schoolList:"+school.toString());
		}
		
	
		SchoolAdmin currentUserr = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("teacherActive", "teacherActive");
		return "TeacherList";
	
	}
	
	

	@RequestMapping(value="/studentList")
	public String allStudentList(@ModelAttribute("schoolAdmin") SchoolAdmin schoolAdmin,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		   String action="action";
		   if(request.getParameter("action")!=null){
		    action=request.getParameter("action");
		   }
		   int[] RouteId= new int[30];
		   if(action.equals("add")){
			String route1=request.getParameter("route1");
			String[] route2=route1.split(",");
			String[] routeNo=new String[30];	
			schoolAdmin.setRole("ROLE_STUDENT");
			schoolAdmin.setEnabled(true);
			gtsService.addAccountInGts(schoolAdmin.getUsername(),schoolAdmin.getPassword(),schoolAdmin.getAccountType());
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			schoolAdmin.setAccountId(userName);
			schoolAdmin.setAccountType("Student");
			model.addAttribute("success", "success");
			School school = schoolAdmin.getSchool();
			System.out.println("School Id:"+school.getId());
			schoolAdmin.setSchool(school);
			schoolAdminService.addSchoolAdmin(schoolAdmin);
			int studentId1= schoolAdminService.getLastSchoolAdminId();
			
			for(int i=0;i<route2.length;i++){
				routeNo=route2[i].split("-");
				for(int j=0;j<routeNo.length;j++)
				{
					if(j==0){
						
						System.out.println(routeNo[j]);
						RouteId[j]=Integer.parseInt(routeNo[j]);
						Route route=routeService.getRouteId(RouteId[j]);
						schoolAdminService.addRouteToStudent(route, studentId1);
						
					}
				}
			}
			
			model.addAttribute(new SchoolAdmin());
			
		}
		if(action.equals("edit")){
			
			
			String route1=request.getParameter("route2");
			String oldRoute=request.getParameter("route3");
			String[] route2=route1.split(",");
			String[] oldRoute1=oldRoute.split(",");
			String[] routeNo=new String[30];
			SchoolAdmin studentId1= schoolAdminService.getSchoolAdminId(schoolAdmin.getId());
			int[] routeIdList=new int[20];
			System.out.println("Length:"+oldRoute1.length);
			for(int i=0;i<oldRoute1.length;i++){
				routeNo=oldRoute1[i].split("-");
				System.out.println("OldOne :"+oldRoute1[i]);
				for(int j=0;j<routeNo.length;j++){
					if(j==1){
						Route route=routeService.getRouteName(routeNo[j]);
						routeIdList[i]=route.getRouteNo();
					}
										
				}
			}
			for(int i=0;i<route2.length;i++){
				routeNo=route2[i].split("-");
				for(int j=0;j<routeNo.length;j++)
				{
					if(j==0){
						
						RouteId[j]=Integer.parseInt(routeNo[j]);
						Route route=routeService.getRouteId(RouteId[j]);
						schoolAdminService.updateRouteToStudent(route,routeIdList[i], studentId1.getId());
						
					}
				}
			}
			
			model.addAttribute(new SchoolAdmin());
			schoolAdmin.setAccountType("Student");
			model.addAttribute(new SchoolAdmin());
			schoolAdmin.setRole("ROLE_STUDENT");
			schoolAdmin.setEnabled(true);
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			schoolAdmin.setAccountId(userName);
			model.addAttribute("edit", "edit");
			schoolAdminService.updateSchoolAdmin(schoolAdmin);
			
		}
		
		
		HttpSession session = request.getSession();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.getAllStudentList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		List<School> schoolList=schoolService.allSchoolList(currentUser.getUsername());
		
		
		SchoolAdmin currentUserr = (SchoolAdmin) session.getAttribute("currentUser");
		List<Route> routeList = routeService.getRouteList(userName);
		List<RouteToStudent> routeToStudentList=schoolAdminService.getAllRouteToStudent();
		for(RouteToStudent routeToStudent : routeToStudentList){
			System.out.println("RouteToStudent :"+routeToStudent.getRouteId());
		}
		
		
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);
		model.addAttribute("routeToStudentList", routeToStudentList);
		model.addAttribute("routeList", routeList);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("studentActive", "studentActive");
		return "studentList";
	}

	
	@RequestMapping(value = "/deleteTeacherList")
	public String deleteTeacherList(@RequestParam("list") String str,HttpServletRequest request,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
	
			String accountID = schoolAdminService.getNameFromId(id);
			System.out.println("accountID:"+accountID);			
			gtsService.deleteAccountInGts(accountID);
			schoolAdminService.deleteSchoolAdmin(id);
		}
		
		
		HttpSession session = request.getSession();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		System.out.println("currentUser"+currentUser.getAccountId());
		List<School> schoolList=schoolService.allSchoolList(currentUser.getAccountId());
		System.out.println("schoolList:"+schoolList.toString());
		for (School school : schoolList) {
			System.out.println("schoolList:"+school.toString());
		}
		
		
		SchoolAdmin currentUserr = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("teacherActive", "teacherActive");
		model.addAttribute(new SchoolAdmin());
		return "TeacherList";
	    
	}
	
	
	@RequestMapping(value = "/deleteParentList")
	public String deleteParentList(@RequestParam("list") String str,HttpServletRequest request,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
	
			String accountID = schoolAdminService.getNameFromId(id);
			System.out.println("accountID:"+accountID);			
			gtsService.deleteAccountInGts(accountID);
			 List<Integer> studentList = schoolAdminService.getStduentFromParentToStudent(id);
	            for (Integer integer : studentList) {
	                SchoolAdmin schoolAdmin = schoolAdminService.getSchoolAdminId(integer);
	                schoolAdmin.setUsed(false);
	                schoolAdminService.updateSchoolAdmin(schoolAdmin);
	            }
	 
			schoolAdminService.deleteSchoolAdmin(id);
		}
		
		HttpSession session = request.getSession();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<SchoolAdmin> schoolAdminList= schoolAdminService.allSchoolAdminList(userName);
		model.addAttribute("schoolAdminList", schoolAdminList);
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		System.out.println("currentUser"+currentUser.getAccountId());
		List<School> schoolList=schoolService.allSchoolList(currentUser.getAccountId());
		System.out.println("schoolList:"+schoolList.toString());
		for (School school : schoolList) {
			System.out.println("schoolList:"+school.toString());
		}
		
		
		SchoolAdmin currentUserr = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUserr.getUsername();
		model.addAttribute("userName", username);
		 List<SchoolAdmin> studentList = schoolAdminService.getAllStudentListForParent(username);
	        model.addAttribute("studentList", studentList);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("parentActive", "parentActive");
		model.addAttribute(new SchoolAdmin());
		return "parentList";
	    
	}

	@RequestMapping(value = "/deleteStudentList")
	public String deleteStudentList(@RequestParam("list") String str,HttpServletRequest request,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			
			String accountID = schoolAdminService.getNameFromId(id);
			System.out.println("accountID:"+accountID);			
			gtsService.deleteAccountInGts(accountID);
			
			schoolAdminService.deleteSchoolAdmin(id);
		}

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
	    List<SchoolAdmin> schoolAdminList= schoolAdminService.getAllStudentList(userName);
		
	    HttpSession session = request.getSession();
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUser.getUsername();
		model.addAttribute("userName", username);
	    
	    model.addAttribute("schoolAdminList", schoolAdminList);
	    model.addAttribute("studentActive", "studentActive");
		return "studentList";
	}
	
	@ResponseBody
	@RequestMapping(value="/editParent",method = RequestMethod.POST)
	public String editParent(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		String [] dataList = list.split(",");
		SchoolAdmin schoolAdmin = new SchoolAdmin();
		School school =schoolService.getSchool(dataList[2]);
		Integer parentId=Integer.parseInt(dataList[0]);
		Integer age=Integer.parseInt(dataList[5]);
		schoolAdmin.setId(parentId);
		schoolAdmin.setName(dataList[1]);
		schoolAdmin.setSchool(school);
		schoolAdmin.setAddress(dataList[3]);
		schoolAdmin.setEmail(dataList[4]);
		schoolAdmin.setAge(age);
		schoolAdmin.setCity(dataList[6]);
		schoolAdmin.setPassword(dataList[7]);
		schoolAdmin.setUsername(dataList[8]);
		schoolAdmin.setAccountType("Parent");
		model.addAttribute(new SchoolAdmin());
		schoolAdmin.setRole("ROLE_PARENT");
		schoolAdmin.setEnabled(true);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		schoolAdmin.setAccountId(userName);
		schoolAdmin.setSchool(school);
		schoolAdminService.updateSchoolAdmin(schoolAdmin);
		return "parentList";
	}
	
	
}
