package com.example.FoodCatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodCatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodcatalogue")
public class FoodCatalogueController {

	
	@Autowired
	FoodCatalogueService foodCatalogueService;
}
