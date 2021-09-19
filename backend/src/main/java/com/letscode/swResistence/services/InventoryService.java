package com.letscode.swResistence.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.dto.InventoryDTO;
import com.letscode.swResistence.entities.Inventory;
import com.letscode.swResistence.repositories.InventoryRepository;
import com.letscode.swResistence.services.exceptions.ResourceNotFoundException;


@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository repository;
	
	@Transactional(readOnly = true)
	public Page<InventoryDTO> findAllPaged(PageRequest pagRequest){
		Page<Inventory> list = repository.findAll(pagRequest);
		return list.map(x -> new InventoryDTO(x));
	}
	
	@Transactional(readOnly = true)
	public InventoryDTO findById(Long id) {
		Optional<Inventory> obj = repository.findById(id);
		Inventory entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new InventoryDTO(entity);
	}	
}
