package com.letscode.swResistence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.entities.Soldier;
import com.letscode.swResistence.repositories.NegotiationRepository;


@Service
public class NegotiationService {
	
	@Autowired
	private NegotiationRepository negotiationRepository;
	
	
	@Transactional(readOnly = true)
    public List<Item> findBySoldierId(Soldier soldier) {
        
        return negotiationRepository.findBySoldierId(soldier);
    }
	
}
