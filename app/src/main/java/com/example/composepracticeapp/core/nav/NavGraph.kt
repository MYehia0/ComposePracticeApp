package com.example.composepracticeapp.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepracticeapp.features.food.ui.FoodScreen
import com.example.composepracticeapp.features.profile.ui.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavGraph(navController)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Profile.route) {
        composable(Screen.Food.route) {
            FoodScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}

sealed class Screen(val route: String) {
    data object Food : Screen("food")
    data object Profile : Screen("profile")
}
