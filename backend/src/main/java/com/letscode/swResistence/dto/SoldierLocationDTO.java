package com.letscode.swResistence.dto;

import java.io.Serializable;

public class SoldierLocationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private Double currentLat;
	private Double currentLng;
	
	public SoldierLocationDTO() {
		
	}
	
	public SoldierLocationDTO(Long id, Double currentLat, Double currentLng) {
		super();
		this.id = id;
		this.currentLat = currentLat;
		this.currentLng = currentLng;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCurrentLat() {
		return currentLat;
	}

	public void setCurrentLat(Double currentLat) {
		this.currentLat = currentLat;
	}

	public Double getCurrentLng() {
		return currentLng;
	}

	public void setCurrentLng(Double currentLng) {
		this.currentLng = currentLng;
	}	

}
