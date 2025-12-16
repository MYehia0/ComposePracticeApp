package com.example.composepracticeapp.features.food.models

data class FoodUiState(
    val meals: List<MealUiState> = emptyList(),
    val easternMeals: List<MealUiState> = emptyList(),
    val westernMeals: List<MealUiState> = emptyList(),
    val restaurants: List<RestaurantUiState> = emptyList(),
    val restaurantMealsMap: Map<String, List<MealUiState>> = emptyMap()
)