package com.fidelit.controller;

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

import com.fidelit.model.Camera;
import com.fidelit.model.Device;
import com.fidelit.model.Route;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.Stop;
import com.fidelit.model.Video;
import com.fidelit.service.CameraService;
import com.fidelit.service.VideoService;

@Controller
@RequestMapping({"/camera"})
public class CameraController {

	@Autowired
	CameraService cameraService;
	
	@Autowired
	VideoService videoService;
	
	@RequestMapping(value="/cameraList")
	String getDeviceList(@ModelAttribute("camera") Camera camera,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		if(action.equals("add")){
			
			 	HttpSession session = request.getSession();
				SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		    	String userName = currentUser.getUsername();
		    	
				camera.setAccountID(userName);
				cameraService.addOrUpdateCamera(camera);
				//gtsService.addDeviceInGts(device);	
				model.addAttribute("added","added");
		}
		if(action.equals("edit")){
			
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			camera.setAccountID(userName);
			System.out.println("camera ID:"+camera.getCameraID());
			System.out.println("camera Status:"+camera.getCameraStatus());
			cameraService.addOrUpdateCamera(camera);
			System.out.println("camera ID:"+camera.getCameraID());
			System.out.println("camera Status:"+camera.getCameraStatus());
		//	gtsService.updateDeviceInGts(device);
			model.addAttribute("updated","updated");
		}
	
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Camera> cameraList = cameraService.getAllCameraByUsername(userName);
		
		HttpSession session = request.getSession();
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUser.getUsername();
		model.addAttribute("userName", username);
		
		model.addAttribute("cameraList",cameraList);
		model.addAttribute("camera",new Camera());
		model.addAttribute("cameraActive", "cameraActive");
		return "cameraList";
		
	}
	
	@RequestMapping(value="/deleteCamera")
	String deleteDevice(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		String cameraId = request.getParameter("cameraList");
		String cameraIdList[] = cameraId.split(",");
		for (String string : cameraIdList) {
			 cameraService.deleteCameraByCameraIdAndAccountId(string,userName);
		    // gtsService.deleteDeviceByUniqueIdAndAccountIdInGts(string, userName);
		}
		System.out.println("**********"+cameraId);
		
        List<Camera> cameraList = cameraService.getAllCameraByUsername(userName);
		
        HttpSession session = request.getSession();
    	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
    	String username = currentUser.getUsername();
    	model.addAttribute("userName", username);
    	
        
        model.addAttribute("cameraList",cameraList);
		model.addAttribute("camera",new Camera());
		model.addAttribute("cameraActive", "cameraActive");
		return "cameraList";
	}
	
	
	@RequestMapping(value="/ListVideos")
	public String listVideos(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		Integer cameraID = null;
		
		if(request.getParameter("cameraID") != null){
	       cameraID = Integer.parseInt(request.getParameter("cameraID"));
		}
		System.out.println("CameraID"+cameraID);
		
		List<Video> videoList = videoService.getallVideoByCameraID(cameraID);
		
		HttpSession session = request.getSession();
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUser.getUsername();
		model.addAttribute("userName", username);
		
		model.addAttribute("videoList",videoList);
		model.addAttribute("video",new Video());
		model.addAttribute("videoActive", "videoActive");
		
			return "videoList";
	}
	
}
