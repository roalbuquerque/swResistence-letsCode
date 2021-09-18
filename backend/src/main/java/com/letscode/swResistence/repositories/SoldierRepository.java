package com.letscode.swResistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Soldier;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Long> {

}
