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
	private Long amountAccusations;
		
	@ManyToOne @JoinColumn(name = "soldier_id")
	private Soldier soldierAccuser;
	
	public Accusation() {
		
	}

	public Accusation(Long id, Long amountAccusations) {
		super();
		this.id = id;
		this.amountAccusations = amountAccusations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmountAccusations() {
		return amountAccusations;
	}

	public void setAmountAccusations(Long amountAccusations) {
		this.amountAccusations = amountAccusations;
	}

	public Soldier getSoldierAccuser() {
		return soldierAccuser;
	}

	public void setSoldierAccuser(Soldier soldierAccuser) {
		this.soldierAccuser = soldierAccuser;
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
		return "Accusation [id=" + id + ", amountAccusations=" + amountAccusations + ", soldierAccuser=" + soldierAccuser + "]";
	}

	
}
