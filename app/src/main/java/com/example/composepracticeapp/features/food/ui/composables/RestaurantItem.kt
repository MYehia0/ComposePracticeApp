package com.example.composepracticeapp.features.food.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepracticeapp.features.food.models.RestaurantUiState

@Composable
fun RestaurantItem(
    restaurant: RestaurantUiState,
    modifier: Modifier = Modifier,
    onClick: (value: RestaurantUiState) -> Unit
) {
    Card(
        modifier = modifier,
        shape = CircleShape
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = restaurant.imageUrl),
            contentDescription = "Meal Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp).clickable { onClick(restaurant) }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(
        restaurant = RestaurantUiState(
            name = "Cheeseburger",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400&h=400&fit=crop",
        ),
        onClick = {}
    )
}
