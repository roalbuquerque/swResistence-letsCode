package com.letscode.swResistence.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.swResistence.dto.ItemDTO;
import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.services.ItemService;

@RestController
@RequestMapping(value = "/itens")
public class ItemResource {

	@Autowired
	private ItemService service;
	
	@GetMapping
	public ResponseEntity<Page<ItemDTO>> findAll(Pageable pageable){
		Page<ItemDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemDTO> findById(@PathVariable Long id){
		ItemDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
