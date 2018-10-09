/*package com.fidelit.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.ChildProgress;
import com.fidelit.model.Route;
import com.fidelit.service.ChildProgressService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("ChildProgressService")


public class ChildProgressimpl implements ChildProgressService {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	
	public void addresult(ChildProgress cp) {
	
		
			Session session = sessionFactory.getCurrentSession();
			session.save(cp);
			System.out.println("In progress");
		}

	}


*/