package com.letscode.swResistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.dto.AccusationDTO;
import com.letscode.swResistence.entities.Accusation;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.AccusationRepository;
import com.letscode.swResistence.repositories.SoldierRepository;
import com.letscode.swResistence.services.exceptions.ResourceNotFoundException;


@Service
public class AccusationService {
	
	@Autowired
	private AccusationRepository accusationRepository;
	
	@Autowired
	private SoldierRepository soldierRepository;
	
	@Transactional(readOnly = true)
	public Page<AccusationDTO> findAllPaged(Pageable pageable) {
		Page <Accusation> list = accusationRepository.findAll(pageable);
		return list.map(x -> new AccusationDTO(x));
	}
	
	@Transactional(readOnly = true)
	public AccusationDTO findById(Long id) {
		Optional<Accusation> obj = accusationRepository.findById(id);
		Accusation entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found")); 	
		return new AccusationDTO(entity);
	}
	
	@Transactional(readOnly = true)
    public List<Accusation> findAccusationsBySoldierAccusedId(Soldier soldier) {
        
        return accusationRepository.findAccusationsBySoldierAccusedId(soldier);
    }
	
	@Transactional
	public AccusationDTO insertAccusation(AccusationDTO dto) {
		Accusation entity = new Accusation();
		entity.setDescriptionAccusation(dto.getDescriptionAccusation());
		Soldier soldierEntity = soldierRepository.findById(dto.getSoldierId()).get();
		entity.setSoldier(soldierEntity);
		Soldier soldierIndicatorEntity = soldierRepository.findById(dto.getSoldierIndicatorId()).get();
		entity.setSoldierIndicator(soldierIndicatorEntity);
		entity = accusationRepository.save(entity);
		return new AccusationDTO(entity);
	}
	
}
