package com.example.FoodCatalogue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String itemName;
	
	private String itemDescription;
	
	private boolean isVeg;
	
	private Number price;
	
	private Integer restaurantId;
	
	@Column(nullable =false,columnDefinition = "INT DEFAULT 0" )
	private Integer quantity;
	
	//The column will not accept null values (nullable = false).
	//The SQL data type of the column will be INT, and its default value will be 0 (columnDefinition = "INT DEFAULT 0").
}
