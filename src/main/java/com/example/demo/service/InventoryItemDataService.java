package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.InventoryItemDTO;
import com.example.demo.entity.InventoryItem;

public interface InventoryItemDataService {

	void createItem(InventoryItemDTO inventoryItemDTO);
	
	void deleteById(Integer id);
	
	Boolean updateItemStatus(Integer id, String status);
	
	List<InventoryItem> getAllInventoryData();
	
	String getStockById(Integer id);
}