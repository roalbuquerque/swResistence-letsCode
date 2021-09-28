package com.letscode.swResistence.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.CategoryDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.dto.SoldierLocationDTO;
import com.letscode.swResistence.services.CategoryService;
import com.letscode.swResistence.services.SoldierService;

@RestController
@RequestMapping(value = "/location")
public class UpdateLocationResource {

	@Autowired
	private SoldierService service;
	
	@Autowired
	private CategoryService categoryService;
	
	private CategoryDTO categorySoldier;
	
	
	@PostMapping
	public ResponseEntity<Void> updateRebelLocation(@RequestBody SoldierLocationDTO soldierLocationDTO) {

		SoldierDTO soldierDto = service.findById(soldierLocationDTO.getId());
		categorySoldier = categoryService.findById(soldierDto.getCategoryId());
		
		if(categorySoldier.getName().equals("Aliado")) {
			copyNewLocation(soldierDto, soldierLocationDTO);
			service.update(soldierDto.getId(), soldierDto);
			System.out.println("Localização atualizada com sucesso!");
		}else {	
			System.out.println("Não é possível atualizar a locação de um rebelde traidor!!" );
		}
		return ResponseEntity.noContent().build();
	}
	
	private void copyNewLocation(SoldierDTO dto, SoldierLocationDTO soldierLocationDTO) {
		dto.setPreviousLat(dto.getCurrentLat());
		dto.setPreviousLng(dto.getCurrentLng());
		dto.setCurrentLat(soldierLocationDTO.getCurrentLat());
		dto.setCurrentLng(soldierLocationDTO.getCurrentLng());
	}
	
}
