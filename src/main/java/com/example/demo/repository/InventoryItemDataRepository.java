package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.InventoryItem;

public interface InventoryItemDataRepository extends JpaRepository<InventoryItem, Integer>{
	
}