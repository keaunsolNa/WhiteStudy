package com.example.demo.menu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.menu.entity.Study;

public interface MenuRepository extends JpaRepository<Study, Integer>{


	int countByNameContaining(String searchValue);

    int countByDescriptionContaining(String description);
    
    List<Study> findByNameContaining(String searchValue, Pageable paging);

    List<Study> findByDescriptionContaining(String description, Pageable paging);
}
