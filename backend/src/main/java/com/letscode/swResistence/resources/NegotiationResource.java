package com.letscode.swResistence.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.CategoryDTO;
import com.letscode.swResistence.dto.NegociationDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.entities.Category;
import com.letscode.swResistence.entities.Inventory;
import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.CategoryRepository;
import com.letscode.swResistence.repositories.InventoryRepository;
import com.letscode.swResistence.services.CategoryService;
import com.letscode.swResistence.services.ItemService;
import com.letscode.swResistence.services.NegotiationService;
import com.letscode.swResistence.services.SoldierService;

@RestController
@RequestMapping(value = "/negotiation")
public class NegotiationResource {

	@Autowired
	private SoldierService soldierService;
	
	@Autowired
	private NegotiationService negotiationService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	private Long totalScoreSoldier1 = 0L;
	private Long totalScoreSoldier2 = 0L;
	private CategoryDTO categorySoldier1;
	private CategoryDTO categorySoldier2;
	private Inventory inventoryTemp1;
	private Inventory inventoryTemp2;
	
	@PostMapping
	public SoldierDTO startNegociation(@RequestBody NegociationDTO negociationDTO) {
		
		//Soldier 1
		SoldierDTO soldierDto1 = soldierService.findById(negociationDTO.getSoldierId1());
		categorySoldier1 = categoryService.findById(soldierDto1.getCategoryId());
		Soldier soldier1 = new Soldier();
		copyDtoToEntity(soldierDto1, soldier1);
		List<Item> itemSoldier1 = negotiationService.findBySoldierId(soldier1);

		//Soldier 2
		
		SoldierDTO soldierDto2 = soldierService.findById(negociationDTO.getSoldierId2());
		categorySoldier2 = categoryService.findById(soldierDto2.getCategoryId());
		Soldier soldier2 = new Soldier();
		copyDtoToEntity(soldierDto2, soldier2);
		List<Item> itemSoldier2 = negotiationService.findBySoldierId(soldier2);
		
		if(categorySoldier1.getName().equals("Aliado") && categorySoldier2.getName().equals("Aliado")) {
			for (Item item : itemSoldier1) {
				totalScoreSoldier1 = totalScoreSoldier1 + calcTotalScore(item.getAmount(), item.getScore());
				CopyToNewInventory1(item);
			}
			for (Item item : itemSoldier2) {
				totalScoreSoldier2 = totalScoreSoldier2 + calcTotalScore(item.getAmount(), item.getScore());
				CopyToNewInventory2(item);
			}
			
			if(totalScoreSoldier1 == totalScoreSoldier2){
				
				for (Item item : itemSoldier1) {
					Long itemId = item.getId();
					item.setId(null);
					item.setInventory(null);
					Item itemTemp = new Item();
					copyItemTemp(item, itemTemp, inventoryTemp1);
					itemservice.insert(item);
					itemservice.delete(itemId);
				}
				
				for (Item item : itemSoldier2) {
					Long itemId = item.getId();
					item.setId(null);
					Item itemTemp = new Item();
					copyItemTemp(item, itemTemp, inventoryTemp2);
					itemservice.insert(itemTemp);
					itemservice.delete(itemId);
				}
				System.out.println("Troca de item realizada com sucesso!");
			}
		}

		return soldierDto1;
	}

	private void CopyToNewInventory1(Item item) {
		inventoryTemp1 = new Inventory();
		inventoryTemp1.setId(item.getInventory().getId());
		inventoryTemp1.setInventoryStatus(item.getInventory().getInventoryStatus());
		inventoryTemp1.setItens(item.getInventory().getItens());
	}

	private void CopyToNewInventory2(Item item) {
		inventoryTemp2 = new Inventory();
		inventoryTemp2.setId(item.getInventory().getId());
		inventoryTemp2.setInventoryStatus(item.getInventory().getInventoryStatus());
		inventoryTemp2.setItens(item.getInventory().getItens());
	}
	
	private void copyDtoToEntity(SoldierDTO dto, Soldier entity) {
		
		entity.setId(dto.getId());
		entity.setSoldierName(dto.getSoldierName());
		entity.setAge(dto.getAge());
		entity.setGenre(dto.getGenre());
		entity.setPreviousLat(dto.getPreviousLat());
		entity.setPreviousLng(dto.getPreviousLng());
		entity.setCurrentLat(dto.getCurrentLat());
		entity.setCurrentLng(dto.getCurrentLng());
		entity.setNameGalaxyBase(dto.getNameGalaxyBase());
		entity.setAccusations(dto.getAccusations());
		Category categoryEntity = categoryRepository.getOne(dto.getCategoryId());
		entity.setCategory(categoryEntity);
	}
	
	private void copyItemTemp(Item item, Item itemTemp, Inventory inventory) {
		
		itemTemp.setAmount(item.getAmount());
		itemTemp.setItemName(item.getItemName());
		itemTemp.setScore(item.getScore());
		itemTemp.setInventory(inventory);
	}
	
	private Long calcTotalScore(Long quantidade, Long ponto) {
		Long total = quantidade * ponto;
		return total;
	}
	
}
