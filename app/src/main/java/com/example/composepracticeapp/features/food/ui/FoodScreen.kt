package com.example.composepracticeapp.features.food.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composepracticeapp.core.ui.composables.Header
import com.example.composepracticeapp.core.ui.theme.ComposePracticeAppTheme
import com.example.composepracticeapp.features.food.models.FoodUiState
import com.example.composepracticeapp.features.food.models.MealUiState
import com.example.composepracticeapp.features.food.models.RestaurantUiState
import com.example.composepracticeapp.features.food.ui.composables.MealItem
import com.example.composepracticeapp.features.food.ui.composables.RestaurantItem
import com.example.composepracticeapp.features.food.viewmodel.FoodViewModel

@Composable
fun FoodScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: FoodViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    Scaffold { innerPadding ->
        FoodScreenContent(
            modifier = modifier.padding(innerPadding),
            state = state.value,
            onRestaurantClick = viewModel::onRestaurantClick,
            onMealClick = viewModel::onMealClick,
            onEasternMealClick = viewModel::onEasternMealClick,
            onWesternMealClick = viewModel::onWesternMealClick
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoodScreenContent(
    modifier: Modifier = Modifier,
    state: FoodUiState,
    onRestaurantClick: (value: RestaurantUiState) -> Unit,
    onMealClick: (value: MealUiState) -> Unit,
    onEasternMealClick: (value: MealUiState) -> Unit,
    onWesternMealClick: (value: MealUiState) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().animateContentSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
        stickyHeader {
            Column (Modifier.background(Color.White)) {
                Header("Restaurants", modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp).fillMaxWidth())
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if(state.restaurants.isNotEmpty()){
                        items(state.restaurants, key = { it.name }) { restaurant ->
                            RestaurantItem(
                                restaurant = restaurant,
                                modifier = Modifier.animateItemPlacement(),
                                onClick = onRestaurantClick
                            )
                        }
                    }
                }
            }
        }
        items(state.meals, key = { it.name }) { meal ->
            MealItem(
                meal = meal,
                modifier = Modifier.padding(horizontal = 8.dp).animateItemPlacement(),
                onClick = onMealClick
            )
        }
        stickyHeader {
            Header("Eastern Meals", modifier = Modifier.background(Color.White).padding(horizontal = 12.dp, vertical = 8.dp).fillMaxWidth())
         }
        items(state.easternMeals, key = { it.name }) { meal ->
            MealItem(
                meal = meal,
                modifier = Modifier.padding(horizontal = 8.dp).animateItemPlacement(),
                onClick = onEasternMealClick
            )
        }
        stickyHeader {
            Header("Western Meals", modifier = Modifier.background(Color.White).padding(horizontal = 12.dp, vertical = 8.dp).fillMaxWidth())
        }
        items(state.westernMeals, key = { it.name }) { meal ->
            MealItem(
                meal = meal,
                modifier = Modifier.padding(horizontal = 8.dp).animateItemPlacement(),
                onClick = onWesternMealClick
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodScreenPreview() {
    ComposePracticeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FoodScreen(
                navController = NavHostController(LocalContext.current),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

// implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0"
// implementation "androidx.navigation:navigation-compose:2.5.3"
// implementation " com.google.dagger:hilt-android:2.44"
// kapt "com.google.dagger:hilt-compiler:2.44"
// id "com.google.dagger.hilt.android" version "2.44" apply false
