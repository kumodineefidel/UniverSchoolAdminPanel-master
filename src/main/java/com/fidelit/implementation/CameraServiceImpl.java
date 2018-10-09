package com.fidelit.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Camera;
import com.fidelit.model.Device;
import com.fidelit.service.CameraService;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("cameraService")
public class CameraServiceImpl implements CameraService{


	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addOrUpdateCamera(Camera camera) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(camera);
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Camera> getAllCameraByUsername(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Camera where accountID = :accountID";
		Query query = session.createQuery(hql);
		query.setString("accountID", userName);
		List<Camera> cameraList  = query.list();
		return cameraList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public Camera getCameraByCameraId(Integer cameraID) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Camera where cameraID = :cameraID";
		Query query = session.createQuery(hql);
		query.setInteger("cameraID", cameraID);
		Camera camera  = (Camera) query.uniqueResult();
		return camera;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Camera> getCameraListByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Camera where accountID = :accountID and isCameraUsed = :isCameraUsed";
		Query query = session.createQuery(hql);
		query.setString("accountID", username);
		query.setBoolean("isCameraUsed", false);
		List<Camera> cameraList  = query.list();
		return cameraList;
		
	}

	@Override
	public void deleteCameraByCameraIdAndAccountId(String cameraId,
			String userName) {
		try{
			   Session session = sessionFactory.openSession();
			   String sql = "delete from Camera where cameraID='"+cameraId+"' and accountID = '"+userName+"' ";
			   SQLQuery query = session.createSQLQuery(sql);	
			   query.executeUpdate();		
			   session.close();
			   
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

}
