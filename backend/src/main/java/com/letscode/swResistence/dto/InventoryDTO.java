package com.letscode.swResistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.letscode.swResistence.entities.Inventory;
import com.letscode.swResistence.entities.Item;

public class InventoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String inventoryStatus;
	private List<Item> itens = new ArrayList<>();
	
	public InventoryDTO() {
		
	}

	public InventoryDTO(Long id, String inventoryStatus) {
		this.id = id;
		this.inventoryStatus = inventoryStatus;
	}
	
	public InventoryDTO(Inventory entity) {
		this.id = entity.getId();
		this.inventoryStatus = entity.getInventoryStatus();
		this.itens = entity.getItens();
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

	public List<Item> getItens() {
		return itens;
	}

	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
	
	
	

	
}
