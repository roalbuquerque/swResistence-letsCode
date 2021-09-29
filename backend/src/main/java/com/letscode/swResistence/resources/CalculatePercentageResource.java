package com.letscode.swResistence.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.PercentageDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.services.SoldierService;

@RestController
@RequestMapping(value = "/porcentages")
public class CalculatePercentageResource {

	@Autowired
	private SoldierService service;
	
	@GetMapping("/percentage-traitors")
	public ResponseEntity<PercentageDTO> getPercentageTraitors(Pageable pageable){
		Page<SoldierDTO> list = service.findAllPaged(pageable);
		double numberOfTraitors = 0;
		
		for (SoldierDTO soldierDTO : list) {
			if(soldierDTO.getCategoryId() == 2) {
				numberOfTraitors = numberOfTraitors + 1;
			}
		}
		int amountTraitors = percentageCalc(list, numberOfTraitors); 
		
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
		int amountAllies = percentageCalc(list, numberOfAllies);
		
		PercentageDTO percentageDTO = new PercentageDTO();
		percentageDTO.setPercentage(amountAllies);
		System.out.println("A porcentagem de Aliados é de: "+ amountAllies +"%");
		
		return ResponseEntity.ok().body(percentageDTO);
	}
	
	private int percentageCalc(Page<SoldierDTO> list, double numberOfTraitors) {
		int listSize = list.getSize();
		int amountTraitors = (int) (((double) numberOfTraitors / listSize) * 100);
		return amountTraitors;
	}
	
}
