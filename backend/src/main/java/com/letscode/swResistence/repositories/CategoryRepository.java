package com.letscode.swResistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letscode.swResistence.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
