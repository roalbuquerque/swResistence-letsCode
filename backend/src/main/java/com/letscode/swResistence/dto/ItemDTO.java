package com.letscode.swResistence.dto;

import java.io.Serializable;

import com.letscode.swResistence.entities.Item;

public class ItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String itemName;
	private Long amount;
	private Long score;
	
	private Long inventoryId;
	
	public ItemDTO() {
		
	}

	public ItemDTO(Long id, String itemName, Long amount, Long score, Long inventoryId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
		this.score = score;
		this.inventoryId = inventoryId;
	}

	public ItemDTO(Item item) {
		id = item.getId();
		itemName = item.getItemName();
		amount = item.getAmount();
		score = item.getScore();
		inventoryId = item.getInventory().getId();
	}

	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

}
