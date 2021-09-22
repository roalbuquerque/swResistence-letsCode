package com.letscode.swResistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Accusation;
import com.letscode.swResistence.entities.Soldier;

@Repository
public interface AccusationRepository extends JpaRepository<Accusation, Long> {

	@Query("SELECT b FROM Soldier a join fetch Accusation b ON a.inventory = b.soldier where b.soldier = ?1")
    List<Accusation> findAccusationsBySoldierAccusedId(Soldier soldier);
}
