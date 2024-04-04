package com.example.FoodCatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodCatalogue.dto.FoodCataloguePage;
import com.example.FoodCatalogue.dto.FoodItemDTO;
import com.example.FoodCatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {

	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		FoodItemDTO foodItemSaved=foodCatalogueService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchRestaurentAndFoodItemById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId){
		FoodCataloguePage foodCataloguePage=foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
	}
}
