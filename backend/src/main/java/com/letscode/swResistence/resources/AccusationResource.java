package com.letscode.swResistence.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.AccusationDTO;
import com.letscode.swResistence.dto.CategoryDTO;
import com.letscode.swResistence.dto.ExecuteAccusationDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.entities.Accusation;
import com.letscode.swResistence.entities.Category;
import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.CategoryRepository;
import com.letscode.swResistence.services.AccusationService;
import com.letscode.swResistence.services.CategoryService;
import com.letscode.swResistence.services.SoldierService;

@RestController
@RequestMapping(value = "/accusations")
public class AccusationResource {

	@Autowired
	private AccusationService accusationService;
	
	@Autowired
	private SoldierService soldierService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	private CategoryDTO categorySoldier1;
	private CategoryDTO categorySoldier2;
	List<Accusation> itemsSoldierAccused;
	List<Item> itemSoldier2;
	
	@GetMapping
	public ResponseEntity<Page<AccusationDTO>> findAll(Pageable pageable){
		Page<AccusationDTO> list = accusationService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AccusationDTO> findById(@PathVariable Long id){
		AccusationDTO dto = accusationService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public SoldierDTO executeAccusation(@RequestBody ExecuteAccusationDTO executeAccusationDTO) {
		
		//soldierIndicator
		SoldierDTO soldierDto1 = soldierService.findById(executeAccusationDTO.getSoldierIndicatorId());
		categorySoldier1 = categoryService.findById(soldierDto1.getCategoryId());
		
		//soldierAccused		
		SoldierDTO soldierDto2 = soldierService.findById(executeAccusationDTO.getSoldierAccusedId());
		categorySoldier2 = categoryService.findById(soldierDto2.getCategoryId());
		
		if(soldierDto1.getId() != soldierDto2.getId()){
			if(categorySoldier1.getName().equals("Aliado") && categorySoldier2.getName().equals("Aliado")) {
				Soldier soldier2 = new Soldier();
				copyDtoToEntity(soldierDto2, soldier2);
				itemsSoldierAccused = accusationService.findAccusationsBySoldierAccusedId(soldier2);
				
				
				System.out.println("teste");
				
			}
			
		}
		return soldierDto1;
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
	
}
