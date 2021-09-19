package com.letscode.swResistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
