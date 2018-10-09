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
import com.fidelit.model.MessageBlog;
import com.fidelit.service.StudentService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("StudentService")
public class StudentServiceImpl implements StudentService {


	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
	@Override
	public List<MessageBlog> getBlogsByClass(String studentclass) {
		Session session;
		List<MessageBlog>  blogList = new ArrayList<MessageBlog>();
		try{
			session = sessionFactory.openSession();
			String hql = "from Blog where studentClass = :studentclass";
			Query query = session.createQuery(hql);
			query.setParameter("studentclass", studentclass);
			blogList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return blogList;
	}

}
