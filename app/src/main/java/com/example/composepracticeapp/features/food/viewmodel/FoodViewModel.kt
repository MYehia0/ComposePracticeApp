package com.example.composepracticeapp.features.food.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composepracticeapp.features.food.models.FoodUiState
import com.example.composepracticeapp.features.food.models.MealUiState
import com.example.composepracticeapp.features.food.models.RestaurantUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()

    init {
        loadData()
    }

    fun onRestaurantClick(restaurant: RestaurantUiState) {
        _state.update { currentState ->
            currentState.copy(
                restaurants = currentState.restaurants.filterNot { it.name == restaurant.name }
            )
        }
    }

    fun onMealClick(meal: MealUiState) {
        _state.update { currentState ->
            currentState.copy(
                meals = currentState.meals.filterNot { it.name == meal.name }
            )
        }
    }

    fun onEasternMealClick(meal: MealUiState) {
        _state.update { currentState ->
            currentState.copy(
                easternMeals = currentState.easternMeals.filterNot { it.name == meal.name }
            )
        }
    }

    fun onWesternMealClick(meal: MealUiState) {
        _state.update { currentState ->
            currentState.copy(
                westernMeals = currentState.westernMeals.filterNot { it.name == meal.name }
            )
        }
    }

    private fun loadData() {
        val generalMeals = listOf(
            MealUiState(
                name = "Club Sandwich",
                imageUrl = "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Eggs Benedict",
                imageUrl = "https://images.unsplash.com/photo-1608039829572-78524f79c4c7?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Grilled Corn",
                imageUrl = "https://images.unsplash.com/photo-1551754655-cd27e38d2076?w=400&h=400&fit=crop"
            )
        )

        val easternMeals = listOf(
            MealUiState(
                name = "Sushi Platter",
                imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Ramen Noodles",
                imageUrl = "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Chicken Biryani",
                imageUrl = "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Chicken Shawarma",
                imageUrl = "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Pad Thai",
                imageUrl = "https://images.unsplash.com/photo-1559314809-0d155014e29e?w=400&h=400&fit=crop"
            )
        )

        val westernMeals = listOf(
            MealUiState(
                name = "Classic Cheeseburger",
                imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Pepperoni Pizza",
                imageUrl = "https://images.unsplash.com/photo-1628840042765-356cda07504e?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Spaghetti Bolognese",
                imageUrl = "https://images.unsplash.com/photo-1622973536968-3ead9e780960?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Grilled Ribeye Steak",
                imageUrl = "https://images.unsplash.com/photo-1600891964092-4316c288032e?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Fish and Chips",
                imageUrl = "https://images.unsplash.com/photo-1579208575657-c595a05383b7?w=400&h=400&fit=crop"
            ),
            MealUiState(
                name = "Caesar Salad",
                imageUrl = "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=400&h=400&fit=crop"
            )
        )

        val restaurants = listOf(
            RestaurantUiState(
                name = "The Burger Joint",
                imageUrl = "https://images.unsplash.com/photo-1552566626-52f8b828add9?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Pizza Palace",
                imageUrl = "https://images.unsplash.com/photo-1579751626657-72bc17010498?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Sushi World",
                imageUrl = "https://images.unsplash.com/photo-1553621042-f6e147245754?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Green Garden",
                imageUrl = "https://images.unsplash.com/photo-1559339352-11d035aa65de?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Taco Fiesta",
                imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Steakhouse Prime",
                imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?w=400&h=400&fit=crop"
            ),
            RestaurantUiState(
                name = "Sweet Tooth Bakery",
                imageUrl = "https://images.unsplash.com/photo-1559620192-032c4bc4674e?w=400&h=400&fit=crop"
            )
        )

        _state.update { currentState ->
            currentState.copy(
                meals = generalMeals,
                easternMeals = easternMeals,
                westernMeals = westernMeals,
                restaurants = restaurants
            )
        }
    }
}