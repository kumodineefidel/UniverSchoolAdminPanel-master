package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Camera;

public interface CameraService {

	void addOrUpdateCamera(Camera camera);

	List<Camera> getAllCameraByUsername(String userName);
	
	Camera getCameraByCameraId(Integer integer);

	List<Camera> getCameraListByUsername(String username);
	
	void deleteCameraByCameraIdAndAccountId(String cameraId,
			String userName);
}
