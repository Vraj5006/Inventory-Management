package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InventoryItemDTO;
import com.example.demo.entity.InventoryItem;
import com.example.demo.entity.InventoryItemDataHistory;
import com.example.demo.repository.InventoryItemDataHistoryRepository;
import com.example.demo.repository.InventoryItemDataRepository;
import com.example.demo.service.InventoryItemDataService;
import com.example.demo.transformer.InventoryItemDataTransformer;

@Service
public class InventoryItemDataServiceImpl implements InventoryItemDataService{

	@Autowired
	private InventoryItemDataRepository inventoryItemDataRepository;
	
	@Autowired
	private InventoryItemDataTransformer inventoryItemDataTransformer;
	
	@Autowired
	private InventoryItemDataHistoryRepository inventoryItemDataHistoryRepository;
	
	
	//Create Item
	@Override
	public void createItem(InventoryItemDTO inventoryItemDTO) {
		InventoryItem inventoryItem = inventoryItemDataTransformer.toEntity(inventoryItemDTO);
		inventoryItem = inventoryItemDataRepository.save(inventoryItem);
		createHistory(inventoryItem.getId(), "Item created");
	}
	
	//Update Item
	@Override
	public Boolean updateItemStatus(Integer id, String status) {
		Optional<InventoryItem> optionalInventoryItem = inventoryItemDataRepository.findById(id);
		
		if (optionalInventoryItem.isEmpty()) {
			return false;
		}
		
		InventoryItem item = optionalInventoryItem.get();
		item.setStatus(status);
		item = inventoryItemDataRepository.save(item);
		createHistory(item.getId(), "Item status is updated");
		return true;
	}
	
	//Get All Items
	@Override
	public List<InventoryItem> getAllInventoryData() {
		return inventoryItemDataRepository.findAll();
	}
	
	
	//Delete Item by id
	@Override
	public void deleteById(Integer id) {
		inventoryItemDataRepository.deleteById(id);
		createHistory(id, "Item is deleted");
	}
	
	//Fetch stock of the item
	@Override
	public String getStockById(Integer id) {
		Optional<InventoryItem> optionalInventoryItem = inventoryItemDataRepository.findById(id);
		
		if (optionalInventoryItem.isEmpty()) {
			return "Invalid item id";
		}
		
		InventoryItem item = optionalInventoryItem.get();
		String returnString = "Item Name: " + item.getItemName() + " Stock: " + item.getQuantity();
		return returnString;
	}
	
	//Create History
	private void createHistory(Integer id, String message) {
		InventoryItemDataHistory inventoryItemDataHistory = new InventoryItemDataHistory();
		inventoryItemDataHistory.setItemId(id);
		inventoryItemDataHistory.setMessage(message);
		inventoryItemDataHistory.setCreatedAt(LocalDateTime.now());
		inventoryItemDataHistoryRepository.save(inventoryItemDataHistory);
	}
}