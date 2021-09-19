package com.letscode.swResistence.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.dto.ItemDTO;
import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.repositories.ItemRepository;
import com.letscode.swResistence.services.exceptions.ResourceNotFoundException;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ItemDTO> findAllPaged(Pageable pageable) {
		Page <Item> list = repository.findAll(pageable);
		return list.map(x -> new ItemDTO(x, x.getInventory().getId()));
	}
	
	@Transactional(readOnly = true)
	public ItemDTO findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		Item entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); 	
		return new ItemDTO(entity, entity.getInventory().getId());
	}
	
}
