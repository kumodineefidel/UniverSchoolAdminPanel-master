package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Video;

public interface VideoService {
	
	List<Video>  getallVideoByCameraID(Integer id);

}
