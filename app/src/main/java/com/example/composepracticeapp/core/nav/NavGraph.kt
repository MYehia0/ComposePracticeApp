package com.example.composepracticeapp.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composepracticeapp.features.food.ui.FoodScreen
import com.example.composepracticeapp.features.food.ui.RestaurantMealScreen
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
        composable(
            Screen.RestaurantMeal.route+"/{restaurantName}",
            arguments = listOf(
                navArgument("restaurantName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val restaurantName = backStackEntry.arguments?.getString("restaurantName")
            RestaurantMealScreen(restaurantName = restaurantName ?: "", onBackClick = { navController.popBackStack() })
        }
    }
}

sealed class Screen(val route: String) {
    data object Food : Screen("food")
    data object Profile : Screen("profile")
    data object RestaurantMeal : Screen("restaurantMeal")
}
