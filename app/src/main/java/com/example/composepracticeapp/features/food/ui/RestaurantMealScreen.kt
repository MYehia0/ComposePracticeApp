package com.example.composepracticeapp.features.food.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepracticeapp.core.ui.theme.ComposePracticeAppTheme
import com.example.composepracticeapp.features.food.models.MealUiState
import com.example.composepracticeapp.features.food.ui.composables.MealItem
import com.example.composepracticeapp.features.food.viewmodel.FoodViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMealScreen(
    restaurantName: String,
    modifier: Modifier = Modifier,
    viewModel: FoodViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state = viewModel.state.collectAsState()
    val restaurantMeals = state.value.restaurantMealsMap[restaurantName] ?: emptyList()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = restaurantName) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        RestaurantMealContent(
            modifier = modifier.padding(innerPadding),
            meals = restaurantMeals,
            onMealClick = { meal ->
                viewModel.onRestaurantMealClick(restaurantName, meal)
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantMealContent(
    modifier: Modifier = Modifier,
    meals: List<MealUiState>,
    onMealClick: (MealUiState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(meals, key = { it.name }) { meal ->
            MealItem(
                meal = meal,
                modifier = Modifier.animateItemPlacement(),
                onClick = onMealClick
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RestaurantDetailScreenPreview() {
    ComposePracticeAppTheme {
        RestaurantMealContent(
            meals = listOf(
                MealUiState(
                    name = "Cheeseburger",
                    imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400&h=400&fit=crop"
                ),
                MealUiState(
                    name = "Double Burger",
                    imageUrl = "https://images.unsplash.com/photo-1572802419224-296b0aeee0d9?w=400&h=400&fit=crop"
                ),
                MealUiState(
                    name = "Bacon Burger",
                    imageUrl = "https://images.unsplash.com/photo-1553979459-d2229ba7433b?w=400&h=400&fit=crop"
                )
            ),
            onMealClick = {}
        )
    }
}