package com.example.composepracticeapp.core.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composepracticeapp.core.ui.theme.Orange

@Composable
fun TextButton(text: String, onClick : () -> Unit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(
            color = Orange,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        ),
        modifier = modifier.clickable { onClick }
    )
}