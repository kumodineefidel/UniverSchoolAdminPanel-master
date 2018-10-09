package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Employee;
import com.fidelit.model.Exam;
import com.fidelit.model.ExamToSubject;
import com.fidelit.model.MessageBlog;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;
import com.fidelit.service.TeacherService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addExam(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(exam);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addSubjectInExam(ExamToSubject examtosubject) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(examtosubject);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Exam getExamByExamId(int examId) {
		Session session;
		Exam  exam = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Exam.class);
			 criteria.add(Restrictions.eq("examId", examId));
			 Object result=criteria.uniqueResult();
			 exam = (Exam)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return exam;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Exam> getAllExam() {
		List<Exam> exam = new ArrayList<Exam>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String sql = "select * from Exam";
				Query query = session.createSQLQuery(sql).addEntity(Exam.class);	
				exam = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		return exam;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public ExamToSubject getExamToSubjectByExamId(int examId) {
		Session session;
		ExamToSubject  exam = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(ExamToSubject.class);
			 criteria.add(Restrictions.eq("exam.examId", examId));
			 Object result=criteria.uniqueResult();
			 exam = (ExamToSubject)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return exam;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public StudentToExam setStudentToExam(StudentToExam ste, ExamToSubject ets,
			SchoolAdmin student, Exam exam) {
		
		ste.setStudent(student);
		ste.setExam(exam);
		
		ste.setSubject1(ets.getSubject1());
		ste.setSubject1min(ets.getSubject1min());
		ste.setSubject1max(ets.getSubject1max());
		
		ste.setSubject2(ets.getSubject2());
		ste.setSubject2min(ets.getSubject2min());
		ste.setSubject2max(ets.getSubject2max());
		
		ste.setSubject3(ets.getSubject3());
		ste.setSubject3min(ets.getSubject3min());
		ste.setSubject3max(ets.getSubject3max());
		
		ste.setSubject4(ets.getSubject4());
		ste.setSubject4min(ets.getSubject4min());
		ste.setSubject4max(ets.getSubject4max());
		
		ste.setSubject5(ets.getSubject5());
		ste.setSubject5min(ets.getSubject5min());
		ste.setSubject5max(ets.getSubject5max());
		
		ste.setSubject6(ets.getSubject6());
		ste.setSubject6min(ets.getSubject6min());
		ste.setSubject6max(ets.getSubject6max());
		
		ste.setSubject7(ets.getSubject7());
		ste.setSubject7min(ets.getSubject7min());
		ste.setSubject7max(ets.getSubject7max());
		
		ste.setSubject8(ets.getSubject8());
		ste.setSubject8min(ets.getSubject8min());
		ste.setSubject8max(ets.getSubject8max());
		
		ste.setSubject9(ets.getSubject9());
		ste.setSubject9min(ets.getSubject9min());
		ste.setSubject9max(ets.getSubject9max());
		
		ste.setSubject10(ets.getSubject10());
		ste.setSubject10min(ets.getSubject10min());
		ste.setSubject10max(ets.getSubject10max());
	
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ste);
		
		return ste;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public StudentToExam getStudentToExamById(int Id) {
		Session session;
		StudentToExam  exam = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(StudentToExam.class);
			 criteria.add(Restrictions.eq("id", Id));
			 Object result=criteria.uniqueResult();
			 exam = (StudentToExam)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return exam;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public void updateStudentToExam(StudentToExam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(exam);		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<StudentToExam> getStudentToExamByStudentId(int studentId) {
		Session session;
		List<StudentToExam>  ste = new ArrayList<StudentToExam>();
		try{
			session = sessionFactory.getCurrentSession();
			String hql = "from StudentToExam where student.id = :studentId";
			Query query = session.createQuery(hql);
			query.setParameter("studentId", studentId);
			ste = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ste;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean checkUniqueExamForStudent(int examId, int studentId) {
		Session session;
		boolean flag = true;
		StudentToExam ste = new StudentToExam();
		try{
		session = sessionFactory.getCurrentSession();
		String hql = "from StudentToExam where student.id = :studentId and exam.examId = :examId";
		Query query = session.createQuery(hql);
		query.setParameter("studentId", studentId);
		query.setParameter("examId", examId);
		ste=(StudentToExam) query.uniqueResult();;
		if(ste != null){
			flag = false;
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addBlog(MessageBlog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<MessageBlog> getMessageBlogList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria creteria = session.createCriteria(MessageBlog.class);
		List<MessageBlog> messageBlog = creteria.list();
		
		return messageBlog;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteBlogMessageById(int id) {
		 Session session = sessionFactory.getCurrentSession();
		 Criteria criteria = session.createCriteria(MessageBlog.class);
		 criteria.add(Restrictions.eq("id", id));
		 Object result=criteria.uniqueResult();
		 MessageBlog messageBlog = (MessageBlog)result;
		 session.delete(messageBlog);
	}

	 
	
}
