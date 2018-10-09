package com.fidelit.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Video;
import com.fidelit.service.VideoService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("videoService")
public class VideoServiceImpl implements VideoService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Video> getallVideoByCameraID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Video where cameraID = :cameraID";
		Query query = session.createQuery(hql);
		query.setInteger("cameraID", id);
		List<Video> videoList  = query.list();
		return videoList;
	}

}
