package com.letscode.swResistence.dto;

import java.io.Serializable;

import com.letscode.swResistence.entities.Soldier;

public class SoldierDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String soldierName;
	private Long age;
	private String genre;
	private Double previousLat;
	private Double previousLng;
	private Double currentLat;
	private Double currentLng;
	private String nameGalaxyBase;
//	private List<Accusation> accusations = new ArrayList<>();
	
	private Long categoryId;
	
	public SoldierDTO() {
		
	}
	
	public SoldierDTO(Long id, String soldierName, Long age, String genre, Double previousLat, Double previousLng,
			Double currentLat, Double currentLng, String nameGalaxyBase, Long categoryId) {
		super();
		this.id = id;
		this.soldierName = soldierName;
		this.age = age;
		this.genre = genre;
		this.previousLat = previousLat;
		this.previousLng = previousLng;
		this.currentLat = currentLat;
		this.currentLng = currentLng;
		this.nameGalaxyBase = nameGalaxyBase;		
		this.categoryId = categoryId;
	}


	public SoldierDTO(Soldier soldier, Long categoryId) {
		super();
		id = soldier.getId();
		soldierName = soldier.getSoldierName();
		age = soldier.getAge();
		genre = soldier.getGenre();
		previousLat = soldier.getPreviousLat();
		previousLng = soldier.getPreviousLng();
		currentLat = soldier.getCurrentLat();
		currentLng = soldier.getCurrentLng();
		nameGalaxyBase = soldier.getNameGalaxyBase();
//		accusations = soldier.getAccusations();
		this.categoryId = soldier.getCategory().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoldierName() {
		return soldierName;
	}

	public void setSoldierName(String soldierName) {
		this.soldierName = soldierName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Double getPreviousLat() {
		return previousLat;
	}

	public void setPreviousLat(Double previousLat) {
		this.previousLat = previousLat;
	}

	public Double getPreviousLng() {
		return previousLng;
	}

	public void setPreviousLng(Double previousLng) {
		this.previousLng = previousLng;
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

	public String getNameGalaxyBase() {
		return nameGalaxyBase;
	}

	public void setNameGalaxyBase(String nameGalaxyBase) {
		this.nameGalaxyBase = nameGalaxyBase;
	}

//	public List<Accusation> getAccusations() {
//		return accusations;
//	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
