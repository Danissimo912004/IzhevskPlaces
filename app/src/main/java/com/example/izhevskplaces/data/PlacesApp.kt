package com.example.izhevskplaces


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.izhevskplaces.UI.CategoryScreen
import com.example.izhevskplaces.UI.PlaceDetailScreen
import com.example.izhevskplaces.UI.PlaceListScreen
import com.example.izhevskplaces.UI.PlacesViewModel

@Composable
fun IzhevskPlacesApp(
    viewModel: PlacesViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "categories"
    ) {
        composable("categories") {
            CategoryScreen(
                onCategoryClick = { category ->
                    navController.navigate("places/$category")
                }
            )
        }

        composable("places/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            PlaceListScreen(
                category = category,
                places = viewModel.getPlacesByCategory(category),
                onPlaceClick = { placeId ->
                    navController.navigate("place_detail/$placeId")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("place_detail/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toIntOrNull() ?: 0
            val place = viewModel.getPlaceById(placeId)
            place?.let {
                PlaceDetailScreen(
                    place = it,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}