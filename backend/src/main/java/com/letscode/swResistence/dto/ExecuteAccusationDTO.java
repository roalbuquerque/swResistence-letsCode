package com.letscode.swResistence.dto;

import java.io.Serializable;

public class ExecuteAccusationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long soldierIndicatorId;
	private Long soldierAccusedId;
	
	public ExecuteAccusationDTO() {
		
	}
	
	public ExecuteAccusationDTO(Long soldierIndicatorId, Long soldierAccusedId) {
		super();
		this.soldierIndicatorId = soldierIndicatorId;
		this.soldierAccusedId = soldierAccusedId;
	}

	public Long getSoldierIndicatorId() {
		return soldierIndicatorId;
	}

	public void setSoldierIndicatorId(Long soldierIndicatorId) {
		this.soldierIndicatorId = soldierIndicatorId;
	}

	public Long getSoldierAccusedId() {
		return soldierAccusedId;
	}

	public void setSoldierAccusedId(Long soldierAccusedId) {
		this.soldierAccusedId = soldierAccusedId;
	}
	
}
