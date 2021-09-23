package com.letscode.swResistence.dto;

import java.io.Serializable;

import com.letscode.swResistence.entities.Accusation;

public class AccusationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descriptionAccusation;
	private Long soldierId;
	private Long soldierIndicatorId;
	
	public AccusationDTO() {
		
	}
	
	public AccusationDTO(Long id, String descriptionAccusation, Long soldierId, Long soldierIndicatorId) {
		super();
		this.id = id;
		this.descriptionAccusation = descriptionAccusation;
		this.soldierId = soldierId;
		this.soldierIndicatorId = soldierIndicatorId;
	}

	public AccusationDTO(Accusation accusation) {
		id = accusation.getId();
		descriptionAccusation = accusation.getDescriptionAccusation();
		soldierId = accusation.getSoldier().getId();
		soldierIndicatorId = accusation.getSoldierIndicator().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescriptionAccusation() {
		return descriptionAccusation;
	}

	public void setDescriptionAccusation(String descriptionAccusation) {
		this.descriptionAccusation = descriptionAccusation;
	}

	public Long getSoldierId() {
		return soldierId;
	}

	public void setSoldierId(Long soldierId) {
		this.soldierId = soldierId;
	}

	public Long getSoldierIndicatorId() {
		return soldierIndicatorId;
	}

	public void setSoldierIndicatorId(Long soldierIndicatorId) {
		this.soldierIndicatorId = soldierIndicatorId;
	}

}
