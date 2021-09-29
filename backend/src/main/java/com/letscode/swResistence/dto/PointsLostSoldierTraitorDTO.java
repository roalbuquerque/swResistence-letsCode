package com.letscode.swResistence.dto;

import java.io.Serializable;

public class PointsLostSoldierTraitorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int pointsLost;
	
	public PointsLostSoldierTraitorDTO() {
		
	}
	
	public PointsLostSoldierTraitorDTO(int pointsLost) {
		super();
		this.pointsLost = pointsLost;
	}

	public int getPointsLost() {
		return pointsLost;
	}

	public void setPointsLost(int pointsLost) {
		this.pointsLost = pointsLost;
	}

}
