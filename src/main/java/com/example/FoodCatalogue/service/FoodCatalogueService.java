package com.example.FoodCatalogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodCatalogue.dto.FoodItemDTO;
import com.example.FoodCatalogue.entity.FoodItem;
import com.example.FoodCatalogue.mapper.FoodItemMapper;
import com.example.FoodCatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	
	@Autowired
	FoodItemRepo foodItemRepo;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
	FoodItem foodItemSavedInDB=foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
	}
	
}
