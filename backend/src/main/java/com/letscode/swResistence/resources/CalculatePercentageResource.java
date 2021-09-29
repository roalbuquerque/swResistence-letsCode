package com.letscode.swResistence.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.PercentageByResourceTypeDTO;
import com.letscode.swResistence.dto.PercentageDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.entities.Category;
import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.CategoryRepository;
import com.letscode.swResistence.services.NegotiationService;
import com.letscode.swResistence.services.SoldierService;

@RestController
@RequestMapping(value = "/porcentages")
public class CalculatePercentageResource {

	@Autowired
	private SoldierService service;
	
	@Autowired
	private NegotiationService negotiationService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/percentage-traitors")
	public ResponseEntity<PercentageDTO> getPercentageTraitors(Pageable pageable){
		Page<SoldierDTO> list = service.findAllPaged(pageable);
		double numberOfTraitors = 0;
		
		for (SoldierDTO soldierDTO : list) {
			if(soldierDTO.getCategoryId() == 2) {
				numberOfTraitors = numberOfTraitors + 1;
			}
		}
		int amountTraitors = amountCalc(list, numberOfTraitors); 
		
		PercentageDTO percentageDTO = new PercentageDTO();
		percentageDTO.setPercentage(amountTraitors);
		System.out.println("A porcentagem de traidores é de: "+ amountTraitors +"%");
		
		return ResponseEntity.ok().body(percentageDTO);
	}

	@GetMapping("/percentage-allies")
	public ResponseEntity<PercentageDTO> getPercentageAllies(Pageable pageable){
		Page<SoldierDTO> list = service.findAllPaged(pageable);
		double numberOfAllies = 0;
		
		for (SoldierDTO soldierDTO : list) {
			if(soldierDTO.getCategoryId() == 1) {
				numberOfAllies = numberOfAllies + 1;
			}
		}
		int amountAllies = amountCalc(list, numberOfAllies);
		
		PercentageDTO percentageDTO = new PercentageDTO();
		percentageDTO.setPercentage(amountAllies);
		System.out.println("A porcentagem de Aliados é de: "+ amountAllies +"%");
		
		return ResponseEntity.ok().body(percentageDTO);
	}
	
	@GetMapping("/percentage-resource-type")
	public ResponseEntity<PercentageByResourceTypeDTO> getQuantityAverageResourceType(Pageable pageable){
		Page<SoldierDTO> list = service.findAllPaged(pageable);
		int totalWater = 0, totalFood = 0, totalWeapon = 0, totalAmmunition = 0, numberOfAllies = 0;
		List<Item> itemSoldier;
				
		for (SoldierDTO soldierDTO : list) {
			if(soldierDTO.getCategoryId() == 1) {
				numberOfAllies = numberOfAllies + 1;
				Soldier soldier1 = new Soldier();
				copyDtoToEntity(soldierDTO, soldier1);
				itemSoldier = negotiationService.findBySoldierId(soldier1);
				for (Item item : itemSoldier) {
					switch (item.getItemName()) {
					  case "Água":
						  totalWater++;
						break;
					  case "Comida":
						  totalFood++;
						    break;
					  case "Arma":
						  totalWeapon++;
					    break;
					  case "Munição":
						  totalAmmunition++;
					    break;
					  default:
					}
				}
			}
		}
		
		double averageOfWater = averageCalc(totalWater, numberOfAllies);
		double averageOfFood = averageCalc(totalFood, numberOfAllies);
		double averageOfWeapon = averageCalc(totalWeapon, numberOfAllies);
		double averageOfAmmunition = averageCalc(totalAmmunition, numberOfAllies);
		
		PercentageByResourceTypeDTO percentageByResourceTypeDTO = new PercentageByResourceTypeDTO();
			
		percentageByResourceTypeDTO.setAverageOfWater(averageOfWater);
		percentageByResourceTypeDTO.setAverageOfFood(averageOfFood);
		percentageByResourceTypeDTO.setAverageOfWeapon(averageOfWeapon);
		percentageByResourceTypeDTO.setAverageOfAmmunition(averageOfAmmunition);
		
		System.out.println("Quantidade média de cada tipo de recurso por rebelde é: \n"
				+ "* "+averageOfWater+" Águas \n"
				+ "* "+averageOfFood+" Comidas \n"
				+ "* "+averageOfWeapon+" Armas \n"
				+ "* "+averageOfAmmunition+" Munições \n"
				+ " ----------------------------------------- ");
		
		return ResponseEntity.ok().body(percentageByResourceTypeDTO);
	}

	private double averageCalc(int totalResource, int numberOfAllies) {
		return BigDecimal.valueOf((double) totalResource / numberOfAllies).setScale(1, RoundingMode.HALF_UP).doubleValue();
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
		Category categoryEntity = categoryRepository.getOne(dto.getCategoryId());
		entity.setCategory(categoryEntity);
	}
	
	private int amountCalc(Page<SoldierDTO> list, double amount) {
		int listSize = list.getSize();
		int totalAmount = (int) (((double) amount / listSize) * 100);
		return totalAmount;
	}
	
}
