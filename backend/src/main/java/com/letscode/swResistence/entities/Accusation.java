package com.letscode.swResistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_accusation")
public class Accusation implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descriptionAccusation;
		
	@ManyToOne @JoinColumn(name = "soldier_id")
	private Soldier soldier;
	
	@ManyToOne @JoinColumn(name = "soldier_Indicator_id")
	private Soldier soldierIndicator;
	
	public Accusation() {
		
	}

	public Accusation(Long id, String descriptionAccusation) {
		super();
		this.id = id;
		this.descriptionAccusation = descriptionAccusation;
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

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}
	
	public Soldier getSoldierIndicator() {
		return soldierIndicator;
	}

	public void setSoldierIndicator(Soldier soldierIndicator) {
		this.soldierIndicator = soldierIndicator;
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
		Accusation other = (Accusation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accusation [id=" + id + ", descriptionAccusation=" + descriptionAccusation + ", soldier=" + soldier
				+ ", soldierIndicator=" + soldierIndicator + "]";
	}
	
}
