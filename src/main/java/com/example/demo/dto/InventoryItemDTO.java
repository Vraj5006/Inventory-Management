package com.example.demo.dto;

import lombok.Data;

@Data
public class InventoryItemDTO {
	private Integer id;
	private String itemName;
	private String sku;
	private String status;
	private Integer quantity;
	private Double  weight;
	private Double height;
	private Double width;
	private Double price;
	private String category;
}