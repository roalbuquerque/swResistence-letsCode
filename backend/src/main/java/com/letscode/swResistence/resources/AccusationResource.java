package com.letscode.swResistence.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.AccusationDTO;
import com.letscode.swResistence.services.AccusationService;

@RestController
@RequestMapping(value = "/accusations")
public class AccusationResource {

	@Autowired
	private AccusationService service;
	
	@GetMapping
	public ResponseEntity<Page<AccusationDTO>> findAll(Pageable pageable){
		Page<AccusationDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AccusationDTO> findById(@PathVariable Long id){
		AccusationDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
