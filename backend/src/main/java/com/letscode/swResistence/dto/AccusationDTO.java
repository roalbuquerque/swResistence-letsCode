package com.letscode.swResistence.dto;

import java.io.Serializable;

import com.letscode.swResistence.entities.Accusation;

public class AccusationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long amountAccusations;
	
	private Long soldierId;
	
	public AccusationDTO() {
		
	}
	
	public AccusationDTO(Long id, Long amountAccusations, Long soldierId) {
		super();
		this.id = id;
		this.amountAccusations = amountAccusations;
		this.soldierId = soldierId;
	}

	public AccusationDTO(Accusation accusation) {
		id = accusation.getId();
		amountAccusations = accusation.getAmountAccusations();
		soldierId = accusation.getSoldierAccuser().getId();
	}

	public Long getId() {
		return id;
	}

	public Long getAmountAccusations() {
		return amountAccusations;
	}

	public void setAmountAccusations(Long amountAccusations) {
		this.amountAccusations = amountAccusations;
	}

	public Long getSoldierId() {
		return soldierId;
	}

	public void setSoldierId(Long soldierId) {
		this.soldierId = soldierId;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
