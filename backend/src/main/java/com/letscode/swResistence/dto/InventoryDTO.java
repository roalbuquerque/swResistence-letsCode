package com.letscode.swResistence.dto;

import java.io.Serializable;

import com.letscode.swResistence.entities.Inventory;

public class InventoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String inventoryStatus;
		
	public InventoryDTO() {
		
	}

	public InventoryDTO(Long id, String inventoryStatus) {
		this.id = id;
		this.inventoryStatus = inventoryStatus;
	}
	
	public InventoryDTO(Inventory entity) {
		this.id = entity.getId();
		this.inventoryStatus = entity.getInventoryStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
}
