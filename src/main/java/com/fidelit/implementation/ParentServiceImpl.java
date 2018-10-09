package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.ParentToStudent;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.ParentService;
import com.fidelit.service.SchoolAdminService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("parentService")
public class ParentServiceImpl implements ParentService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private SchoolAdminService schoolAdminService;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<SchoolAdmin> getChildrenByParentId(int parentId) {
		Session session;
		List<ParentToStudent>  studentListInt = new ArrayList<ParentToStudent>();
		List<SchoolAdmin>  studentList = new ArrayList<SchoolAdmin>();
		try{
			session = sessionFactory.getCurrentSession();
			String hql = "from ParentToStudent where parentId = :parentId";
			Query query = session.createQuery(hql);
			query.setParameter("parentId", parentId);
			studentListInt = query.list();
			for (ParentToStudent student : studentListInt) {
				int studentId = student.getStudentId();
				System.out.println("studentId:"+studentId);
				SchoolAdmin studentObj = schoolAdminService.getSchoolAdminId(studentId);
				System.out.println("studentObj:"+studentObj.getId());
				studentList.add(studentObj);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return studentList;
	}

}
