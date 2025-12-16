package com.example.composepracticeapp.features.food.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.composepracticeapp.core.nav.Screen
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

    fun onRestaurantClick(restaurant: RestaurantUiState, navController: NavController) {
        navController.navigate(Screen.RestaurantMeal.route+"/${restaurant.name}")
//        _state.update { currentState ->
//            currentState.copy(
//                restaurants = currentState.restaurants.filterNot { it.name == restaurant.name }
//            )
//        }
    }

    fun onRestaurantMealClick(restaurant: String, meal: MealUiState) {
        _state.update { currentState ->
            currentState.copy(
                restaurantMealsMap = currentState.restaurantMealsMap.mapValues { (key, meals) ->
                    if (key == restaurant) {
                        meals.filterNot { it.name == meal.name }
                    } else {
                        meals
                    }
                }
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

        val restaurantMealsMap = mapOf(
            "The Burger Joint" to listOf(
                MealUiState("Classic Burger", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400&h=400&fit=crop"),
                MealUiState("Cheese Burger", "https://images.unsplash.com/photo-1572802419224-296b0aeee0d9?w=400&h=400&fit=crop"),
                MealUiState("Bacon Burger", "https://images.unsplash.com/photo-1553979459-d2229ba7433b?w=400&h=400&fit=crop"),
                MealUiState("Double Burger", "https://images.unsplash.com/photo-1550547660-d9450f859349?w=400&h=400&fit=crop"),
                MealUiState("Veggie Burger", "https://images.unsplash.com/photo-1520072959219-c595dc870360?w=400&h=400&fit=crop"),
                MealUiState("Chicken Burger", "https://images.unsplash.com/photo-1585238341710-4a3cf2e0cde0?w=400&h=400&fit=crop"),
                MealUiState("BBQ Burger", "https://images.unsplash.com/photo-1594212699903-ec8a3eca50f5?w=400&h=400&fit=crop"),
                MealUiState("Mushroom Burger", "https://images.unsplash.com/photo-1571091718767-18b5b1457add?w=400&h=400&fit=crop")
            ),
            "Pizza Palace" to listOf(
                MealUiState("Margherita Pizza", "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=400&h=400&fit=crop"),
                MealUiState("Pepperoni Pizza", "https://images.unsplash.com/photo-1628840042765-356cda07504e?w=400&h=400&fit=crop"),
                MealUiState("BBQ Chicken Pizza", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=400&h=400&fit=crop"),
                MealUiState("Hawaiian Pizza", "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=400&h=400&fit=crop"),
                MealUiState("Veggie Supreme", "https://images.unsplash.com/photo-1571997478779-2adcbbe9ab2f?w=400&h=400&fit=crop"),
                MealUiState("Meat Lovers", "https://images.unsplash.com/photo-1590534047427-91cf7d2fb0b8?w=400&h=400&fit=crop"),
                MealUiState("Four Cheese", "https://images.unsplash.com/photo-1458642849426-cfb724f15ef7?w=400&h=400&fit=crop"),
                MealUiState("Buffalo Chicken", "https://images.unsplash.com/photo-1571066811602-716837d681de?w=400&h=400&fit=crop"),
                MealUiState("White Pizza", "https://images.unsplash.com/photo-1565299507177-b0ac66763828?w=400&h=400&fit=crop")
            ),
            "Sushi World" to listOf(
                MealUiState("California Roll", "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?w=400&h=400&fit=crop"),
                MealUiState("Salmon Nigiri", "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=400&h=400&fit=crop"),
                MealUiState("Tuna Sashimi", "https://images.unsplash.com/photo-1617093727343-374698b1b08d?w=400&h=400&fit=crop"),
                MealUiState("Dragon Roll", "https://images.unsplash.com/photo-1583623025817-d180a2221d0a?w=400&h=400&fit=crop"),
                MealUiState("Rainbow Roll", "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?w=400&h=400&fit=crop"),
                MealUiState("Spicy Tuna Roll", "https://images.unsplash.com/photo-1611143669185-af224c5e3252?w=400&h=400&fit=crop"),
                MealUiState("Tempura Roll", "https://images.unsplash.com/photo-1564489563601-c53cfc451e93?w=400&h=400&fit=crop"),
                MealUiState("Philadelphia Roll", "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?w=400&h=400&fit=crop")
            ),
            "Green Garden" to listOf(
                MealUiState("Caesar Salad", "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?w=400&h=400&fit=crop"),
                MealUiState("Greek Salad", "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?w=400&h=400&fit=crop"),
                MealUiState("Quinoa Bowl", "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=400&h=400&fit=crop"),
                MealUiState("Buddha Bowl", "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=400&h=400&fit=crop"),
                MealUiState("Caprese Salad", "https://images.unsplash.com/photo-1608897013039-887f21d8c804?w=400&h=400&fit=crop"),
                MealUiState("Cobb Salad", "https://images.unsplash.com/photo-1546793665-c74683f339c1?w=400&h=400&fit=crop"),
                MealUiState("Kale Salad", "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=400&h=400&fit=crop"),
                MealUiState("Taco Salad", "https://images.unsplash.com/photo-1592417817098-8fd3d9eb14a5?w=400&h=400&fit=crop")
            ),
            "Taco Fiesta" to listOf(
                MealUiState("Beef Tacos", "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?w=400&h=400&fit=crop"),
                MealUiState("Chicken Tacos", "https://images.unsplash.com/photo-1599974579688-8dbdd335538f?w=400&h=400&fit=crop"),
                MealUiState("Fish Tacos", "https://images.unsplash.com/photo-1624300629298-e9de39c13be5?w=400&h=400&fit=crop"),
                MealUiState("Shrimp Tacos", "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=400&h=400&fit=crop"),
                MealUiState("Carnitas Tacos", "https://images.unsplash.com/photo-1615870216519-2f9fa575fa5c?w=400&h=400&fit=crop"),
                MealUiState("Al Pastor Tacos", "https://images.unsplash.com/photo-1613514785940-daed07799d9b?w=400&h=400&fit=crop"),
                MealUiState("Veggie Tacos", "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=400&h=400&fit=crop"),
                MealUiState("Burrito Bowl", "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?w=400&h=400&fit=crop"),
                MealUiState("Quesadilla", "https://images.unsplash.com/photo-1618040996337-56904b7850b9?w=400&h=400&fit=crop")
            ),
            "Steakhouse Prime" to listOf(
                MealUiState("Ribeye Steak", "https://images.unsplash.com/photo-1600891964092-4316c288032e?w=400&h=400&fit=crop"),
                MealUiState("Filet Mignon", "https://images.unsplash.com/photo-1558030006-450675393462?w=400&h=400&fit=crop"),
                MealUiState("T-Bone Steak", "https://images.unsplash.com/photo-1546833998-877b37c2e5c6?w=400&h=400&fit=crop"),
                MealUiState("New York Strip", "https://images.unsplash.com/photo-1624667712743-e6a94a1f3b68?w=400&h=400&fit=crop"),
                MealUiState("Porterhouse", "https://images.unsplash.com/photo-1604503468506-a8da13d82791?w=400&h=400&fit=crop"),
                MealUiState("Prime Rib", "https://images.unsplash.com/photo-1603360946369-dc9bb6258143?w=400&h=400&fit=crop"),
                MealUiState("Lamb Chops", "https://images.unsplash.com/photo-1560781290-7dc94c0f8f4f?w=400&h=400&fit=crop"),
                MealUiState("BBQ Ribs", "https://images.unsplash.com/photo-1529193591184-b1d58069ecdd?w=400&h=400&fit=crop")
            ),
            "Sweet Tooth Bakery" to listOf(
                MealUiState("Chocolate Cake", "https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=400&h=400&fit=crop"),
                MealUiState("Red Velvet Cake", "https://images.unsplash.com/photo-1586788680434-30d324b2d46f?w=400&h=400&fit=crop"),
                MealUiState("Cheesecake", "https://images.unsplash.com/photo-1533134242820-b53f4d04bf98?w=400&h=400&fit=crop"),
                MealUiState("Tiramisu", "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=400&h=400&fit=crop"),
                MealUiState("Apple Pie", "https://images.unsplash.com/photo-1535920527002-b35e96722eb9?w=400&h=400&fit=crop"),
                MealUiState("Croissant", "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=400&h=400&fit=crop"),
                MealUiState("Chocolate Chip Cookie", "https://images.unsplash.com/photo-1499636136210-6f4ee915583e?w=400&h=400&fit=crop"),
                MealUiState("Brownie", "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=400&h=400&fit=crop"),
                MealUiState("Cupcake", "https://images.unsplash.com/photo-1614707267537-b85aaf00c4b7?w=400&h=400&fit=crop"),
                MealUiState("Donut", "https://images.unsplash.com/photo-1551024506-0bccd828d307?w=400&h=400&fit=crop")
            )
        )

        _state.update { currentState ->
            currentState.copy(
                meals = generalMeals,
                easternMeals = easternMeals,
                westernMeals = westernMeals,
                restaurants = restaurants,
                restaurantMealsMap = restaurantMealsMap
            )
        }
    }
}