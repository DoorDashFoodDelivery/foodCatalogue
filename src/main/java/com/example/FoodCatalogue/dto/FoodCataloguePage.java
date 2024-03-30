package com.example.FoodCatalogue.dto;

import java.util.List;

import com.example.FoodCatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

	private List<FoodItem> foodItemList;
	
	private Restaurent restaurent;
}
