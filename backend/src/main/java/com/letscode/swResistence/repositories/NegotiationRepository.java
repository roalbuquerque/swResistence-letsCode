package com.letscode.swResistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Item;
import com.letscode.swResistence.entities.Soldier;

@Repository
public interface NegotiationRepository extends JpaRepository<Item, Long> {

	@Query("SELECT b FROM Inventory a join fetch Item b ON a.soldier = b.inventory where a.soldier = ?1 and a.inventoryStatus = 'ATIVO'")
    List<Item> findBySoldierId(Soldier soldier);
}
