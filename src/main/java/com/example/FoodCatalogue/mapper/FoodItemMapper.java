package com.example.FoodCatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.FoodCatalogue.dto.FoodItemDTO;
import com.example.FoodCatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE=Mappers.getMapper(FoodItemMapper.class);
	//For example, if FoodItemMapper is a class or interface, FoodItemMapper.class would give you the Class object representing that class or interface, which you can then use for various reflective operations such as instantiation, method invocation, or annotation inspection.
	
	FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
	
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
