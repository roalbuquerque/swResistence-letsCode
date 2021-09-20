package com.letscode.swResistence.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.dto.ItemDTO;
import com.letscode.swResistence.entities.Inventory;
import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.repositories.InventoryRepository;
import com.letscode.swResistence.repositories.ItemRepository;
import com.letscode.swResistence.services.exceptions.DatabaseException;
import com.letscode.swResistence.services.exceptions.ResourceNotFoundException;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	public Page<ItemDTO> findAllPaged(Pageable pageable) {
		Page <Item> list = itemRepository.findAll(pageable);
		return list.map(x -> new ItemDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ItemDTO findById(Long id) {
		Optional<Item> obj = itemRepository.findById(id);
		Item entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); 	
		return new ItemDTO(entity);
	}
	
	@Transactional
	public ItemDTO insert(Item item) {
		Item entity = new Item();
		entity = itemRepository.save(item);
		return new ItemDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			itemRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
