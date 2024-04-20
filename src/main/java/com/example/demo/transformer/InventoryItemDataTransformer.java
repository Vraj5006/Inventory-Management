package com.example.demo.transformer;

import org.springframework.stereotype.Component;

import com.example.demo.dto.InventoryItemDTO;
import com.example.demo.entity.InventoryItem;

@Component
public class InventoryItemDataTransformer {

	public InventoryItem toEntity(InventoryItemDTO inventoryItemDTO) {
		InventoryItem inventoryItem = new InventoryItem();
		inventoryItem.setItemName(inventoryItemDTO.getItemName());
		inventoryItem.setSku(inventoryItemDTO.getSku());
		inventoryItem.setQuantity(inventoryItemDTO.getQuantity());
		inventoryItem.setStatus(inventoryItemDTO.getStatus());
		inventoryItem.setPrice(inventoryItemDTO.getPrice());
		inventoryItem.setWeight(inventoryItemDTO.getWeight());
		inventoryItem.setHeight(inventoryItemDTO.getHeight());
		inventoryItem.setWidth(inventoryItemDTO.getWidth());
		inventoryItem.setCategory(inventoryItemDTO.getCategory());
		return inventoryItem;
	}
}