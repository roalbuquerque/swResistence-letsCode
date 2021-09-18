package com.letscode.swResistence.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.dto.SoldierDTO;
import com.letscode.swResistence.entities.Category;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.CategoryRepository;
import com.letscode.swResistence.repositories.SoldierRepository;
import com.letscode.swResistence.services.exceptions.DatabaseException;
import com.letscode.swResistence.services.exceptions.ResourceNotFoundException;


@Service
public class SoldierService {
	
	@Autowired
	private SoldierRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<SoldierDTO> findAllPaged(Pageable pageable) {
		Page <Soldier> list = repository.findAll(pageable);
		return list.map(x -> new SoldierDTO(x, x.getCategory().getId()));
	}
	
	@Transactional(readOnly = true)
	public SoldierDTO findById(Long id) {
		Optional<Soldier> obj = repository.findById(id);
		Soldier entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); 	
		return new SoldierDTO(entity, entity.getCategory().getId());
	}

	@Transactional
	public SoldierDTO insert(SoldierDTO dto) {
		Soldier entity = new Soldier();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new SoldierDTO(entity, entity.getCategory().getId());
	}
	
	@Transactional
	public SoldierDTO update(Long id, SoldierDTO dto) {
		try {
			Soldier entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new SoldierDTO(entity, entity.getCategory().getId());
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(SoldierDTO dto, Soldier entity) {
		
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
}
