package com.example.composepracticeapp.core.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
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
        restaurantMealScreen(navController)
    }
}



sealed class Screen(val route: String) {
    data object Food : Screen("food")
    data object Profile : Screen("profile")
    data object RestaurantMeal : Screen("restaurantMeal")
}

fun NavGraphBuilder.restaurantMealScreen(navController: NavHostController) {
    composable(
        Screen.RestaurantMeal.route + "/{${RestaurantMealScreenArgs.RESTAURANT_NAME_ARG}}",
        arguments = listOf(
            navArgument(RestaurantMealScreenArgs.RESTAURANT_NAME_ARG) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        val restaurantName = backStackEntry.arguments?.getString(RestaurantMealScreenArgs.RESTAURANT_NAME_ARG)
        RestaurantMealScreen(restaurantName = restaurantName ?: "", onBackClick = { navController.popBackStack() })
    }
}

fun NavController.navigateRestaurantMealScreen(restaurantName: String) {
    navigate(Screen.RestaurantMeal.route + "/$restaurantName")
}

class RestaurantMealScreenArgs(savedStateHandle: SavedStateHandle){
    val restaurantName: String = checkNotNull(savedStateHandle[RestaurantMealScreenArgs.RESTAURANT_NAME_ARG])
    companion object{
        const val RESTAURANT_NAME_ARG = "restaurantName"
    }
}
