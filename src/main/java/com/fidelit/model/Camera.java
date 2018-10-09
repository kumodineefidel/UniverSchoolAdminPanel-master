package com.fidelit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Camera")
public class Camera implements Serializable{

	private Integer cameraID;
	private String vehicleID;
	private Boolean cameraStatus;
	private String accountID;
	private Boolean isCameraUsed = false;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCameraID() {
		return cameraID;
	}
	public void setCameraID(Integer cameraID) {
		this.cameraID = cameraID;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public Boolean getCameraStatus() {
		return cameraStatus;
	}
	public void setCameraStatus(Boolean cameraStatus) {
		this.cameraStatus = cameraStatus;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public Boolean getIsCameraUsed() {
		return isCameraUsed;
	}
	public void setIsCameraUsed(Boolean isCameraUsed) {
		this.isCameraUsed = isCameraUsed;
	}
	
	
}
