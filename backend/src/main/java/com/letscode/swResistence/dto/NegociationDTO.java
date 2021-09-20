package com.letscode.swResistence.dto;

import java.io.Serializable;

public class NegociationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long soldierId1;
	private Long soldierId2;
	
	public NegociationDTO() {
		
	}
	
	public NegociationDTO(Long soldierId1, Long soldierId2) {
		super();
		this.soldierId1 = soldierId1;
		this.soldierId1 = soldierId1;
		
	}

	public Long getSoldierId1() {
		return soldierId1;
	}

	public void setSoldierId1(Long soldierId1) {
		this.soldierId1 = soldierId1;
	}

	public Long getSoldierId2() {
		return soldierId2;
	}

	public void setSoldierId2(Long soldierId2) {
		this.soldierId2 = soldierId2;
	}

}
