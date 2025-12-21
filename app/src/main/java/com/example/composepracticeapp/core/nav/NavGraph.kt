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

sealed class Screen(val route: String) {
    data object Profile : Screen("profile")
    data object Food : Screen("food")
    data object RestaurantMeal : Screen("restaurantMeal") {
        const val RESTAURANT_NAME_ARG = "restaurantName"
        fun createRoute(restaurantName: String): String {
            return "$route/$restaurantName"
        }
        val routeWithArgs: String = "$route/{$RESTAURANT_NAME_ARG}"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavGraph(navController)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route
    ) {
        profileScreen(navController)
        foodScreen(navController)
        restaurantMealScreen(navController)
    }
}

private fun NavGraphBuilder.profileScreen(navController: NavHostController) {
    composable(route = Screen.Profile.route) {
        ProfileScreen(navController = navController)
    }
}

private fun NavGraphBuilder.foodScreen(navController: NavHostController) {
    composable(route = Screen.Food.route) {
        FoodScreen(navController = navController)
    }
}

private fun NavGraphBuilder.restaurantMealScreen(navController: NavHostController) {
    composable(
        route = Screen.RestaurantMeal.routeWithArgs,
        arguments = listOf(
            navArgument(Screen.RestaurantMeal.RESTAURANT_NAME_ARG) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        val restaurantName = backStackEntry.arguments
            ?.getString(Screen.RestaurantMeal.RESTAURANT_NAME_ARG)
            ?: return@composable

        RestaurantMealScreen(
            restaurantName = restaurantName,
            onBackClick = { navController.popBackStack() }
        )
    }
}

//fun NavController.navigateToProfile() {
//    navigate(Screen.Profile.route) {
//        launchSingleTop = true
//    }
//}

fun NavController.navigateToFood() {
    navigate(Screen.Food.route) {
        launchSingleTop = true
    }
}

fun NavController.navigateToRestaurantMeal(restaurantName: String) {
    navigate(Screen.RestaurantMeal.createRoute(restaurantName))
}

//fun NavController.navigateToProfileAndClearBackStack() {
//    navigate(Screen.Profile.route) {
//        popUpTo(graph.startDestinationId) {
//            inclusive = true
//        }
//        launchSingleTop = true
//    }
//}