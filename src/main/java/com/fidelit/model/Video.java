package com.fidelit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video implements Serializable{
	private Integer videoID;
	private String videoDate;
	private Integer cameraID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getVideoID() {
		return videoID;
	}
	public void setVideoID(Integer videoID) {
		this.videoID = videoID;
	}
	
	public String getVideoDate() {
		return videoDate;
	}
	public void setVideoDate(String videoDate) {
		this.videoDate = videoDate;
	}
	public Integer getCameraID() {
		return cameraID;
	}
	public void setCameraID(Integer cameraID) {
		this.cameraID = cameraID;
	}
	

}
