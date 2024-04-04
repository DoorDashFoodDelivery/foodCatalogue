package com.example.FoodCatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	@Autowired
	RestTemplate restTemplate;
	
	
	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
	FoodItem foodItemSavedInDB=foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
	System.out.println(foodItemSavedInDB);
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
	}

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
		List<FoodItem> foodItemList=fetchFoodItemList(restaurantId);
		Restaurent restaurent=fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		return	createFoodCataloguePage(foodItemList,restaurent);
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurent restaurent) {
		FoodCataloguePage foodCataloguePage=new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurent(restaurent);
		return foodCataloguePage;
	}

	private Restaurent fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		return	restTemplate.getForObject("http://Restaurent-Service/restaurant/fetchById/"+restaurantId,Restaurent.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		
		return foodItemRepo.findByRestaurantId(restaurantId);
	}
	
}
