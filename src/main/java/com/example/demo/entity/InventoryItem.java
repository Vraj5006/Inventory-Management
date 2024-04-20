package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory_item")
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "weight")
	private Double  weight;
	
	@Column(name = "height")
	private Double height;
	
	@Column(name = "width")
	private Double width;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "category")
	private String category;
}