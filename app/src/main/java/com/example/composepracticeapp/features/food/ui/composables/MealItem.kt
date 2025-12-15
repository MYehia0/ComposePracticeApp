package com.example.composepracticeapp.features.food.ui.composables

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composepracticeapp.features.food.models.MealUiState

@Composable
fun MealItem(
    meal: MealUiState,
    modifier: Modifier = Modifier,
    onClick: (value: MealUiState) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth().clickable { onClick(meal) },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberAsyncImagePainter(model = meal.imageUrl),
                contentDescription = "Meal Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().size(200.dp)
            )
            Text(
                text = meal.name,
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 16.dp),
                style = MaterialTheme.typography.titleMedium
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealItemPreview() {
    MealItem(
        meal = MealUiState(
            name = "Cheeseburger",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400&h=400&fit=crop",
        ),
        onClick = {}
    )
}
