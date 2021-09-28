package com.letscode.swResistence.dto;

import java.io.Serializable;

public class PercentageDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int percentage;
	
	public PercentageDTO() {
		
	}

	public PercentageDTO(int percentage) {
		super();
		this.percentage = percentage;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
}
