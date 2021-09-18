package com.letscode.swResistence.entities;

import java.io.Serializable;

public class Soldier implements Serializable{
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
	private Long accusations;
	
	public Soldier() {
		
	}

	public Soldier(Long id, String soldierName, Long age, String genre, Double previousLat, Double previousLng,
			Double currentLat, Double currentLng, String nameGalaxyBase, Long accusations) {
		this.id = id;
		this.soldierName = soldierName;
		this.age = age;
		this.genre = genre;
		this.previousLat = previousLat;
		this.previousLng = previousLng;
		this.currentLat = currentLat;
		this.currentLng = currentLng;
		this.nameGalaxyBase = nameGalaxyBase;
		this.accusations = accusations;
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

	public Long getAccusations() {
		return accusations;
	}

	public void setAccusations(Long accusations) {
		this.accusations = accusations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soldier other = (Soldier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
