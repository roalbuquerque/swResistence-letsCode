package com.letscode.swResistence.dto;

import java.io.Serializable;

public class PercentageByResourceTypeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private double averageOfWater;
	private double averageOfFood;
	private double averageOfWeapon;
	private double averageOfAmmunition;
	
	public PercentageByResourceTypeDTO() {
		
	}

	public PercentageByResourceTypeDTO(double averageOfWater, double averageOfFood, double averageOfWeapon,
			double averageOfAmmunition) {
		super();
		this.averageOfWater = averageOfWater;
		this.averageOfFood = averageOfFood;
		this.averageOfWeapon = averageOfWeapon;
		this.averageOfAmmunition = averageOfAmmunition;
	}

	public double getAverageOfWater() {
		return averageOfWater;
	}

	public void setAverageOfWater(double averageOfWater) {
		this.averageOfWater = averageOfWater;
	}

	public double getAverageOfFood() {
		return averageOfFood;
	}

	public void setAverageOfFood(double averageOfFood) {
		this.averageOfFood = averageOfFood;
	}

	public double getAverageOfWeapon() {
		return averageOfWeapon;
	}

	public void setAverageOfWeapon(double averageOfWeapon) {
		this.averageOfWeapon = averageOfWeapon;
	}

	public double getAverageOfAmmunition() {
		return averageOfAmmunition;
	}

	public void setAverageOfAmmunition(double averageOfAmmunition) {
		this.averageOfAmmunition = averageOfAmmunition;
	}

}
