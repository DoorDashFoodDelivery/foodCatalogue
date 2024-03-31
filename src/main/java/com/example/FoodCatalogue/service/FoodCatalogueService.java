package com.example.FoodCatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodCatalogue.dto.FoodCataloguePage;
import com.example.FoodCatalogue.dto.FoodItemDTO;
import com.example.FoodCatalogue.dto.Restaurent;
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

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		List<FoodItem> foodItemList=fetchFoodItemList(restaurantId);
		Restaurent restaurent=fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		createFoodCataloguePage(foodItemList,restaurent);
		return null;
	}

	private void createFoodCataloguePage(List<FoodItem> foodItemList, Restaurent restaurent) {
		// TODO Auto-generated method stub
		
	}

	private Restaurent fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
