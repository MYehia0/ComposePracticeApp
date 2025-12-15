package com.example.composepracticeapp.core.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Header(title: String, subtitle: String? = null, modifier: Modifier = Modifier.fillMaxWidth()) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        if(subtitle != null)
            Text(
                text = subtitle,
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderPreview() {
    Header(
        title = "Account",
        subtitle = "Edit and Manage your account"
    )
}