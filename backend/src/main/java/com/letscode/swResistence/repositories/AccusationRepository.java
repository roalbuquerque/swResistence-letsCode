package com.letscode.swResistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Accusation;

@Repository
public interface AccusationRepository extends JpaRepository<Accusation, Long> {

}
