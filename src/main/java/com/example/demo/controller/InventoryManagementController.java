package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InventoryItemDTO;
import com.example.demo.entity.InventoryItem;
import com.example.demo.service.InventoryItemDataService;

@RestController
@RequestMapping("/inventory/item")
public class InventoryManagementController {
	
	@Autowired
	private InventoryItemDataService inventoryItemDataService;
	
	@GetMapping("/getAll")
	public List<InventoryItem> getAllItems() {
		return inventoryItemDataService.getAllInventoryData();
	}
	
	@GetMapping("/getStock")
	public String getStockByItemId(@RequestParam Integer id) {
		return inventoryItemDataService.getStockById(id);
	}

	@PostMapping("/create")
	public String createItem(@RequestBody InventoryItemDTO inventoryItemDTO) {
		inventoryItemDataService.createItem(inventoryItemDTO);
		return "Item created";
	}
	
	@PutMapping("/update")
	public String updateItemByItemId(@RequestParam Integer id, @RequestBody String status) {
		boolean isItemUpdated = inventoryItemDataService.updateItemStatus(id, status);
		
		if (isItemUpdated) {
			return "Item updated";
		} else {
			return "Invalid item id";
		}
	}
	
	@DeleteMapping("/delete")
	public String deleteItemById (@RequestParam Integer id) {
		inventoryItemDataService.deleteById(id);
		return "Item deleted"; 
	}
}