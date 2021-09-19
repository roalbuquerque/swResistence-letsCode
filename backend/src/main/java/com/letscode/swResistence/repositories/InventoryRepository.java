package com.letscode.swResistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
