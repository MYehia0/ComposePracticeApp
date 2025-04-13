package com.example.composepracticeapp.features.profile.presentation.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepracticeapp.R
import com.example.composepracticeapp.core.ui.theme.LightGreen

@Composable
fun SaveButton(onClick: () -> Unit){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(LightGreen),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
    ) {
        Text(
            text = stringResource(id = R.string.save),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
            )
        )
    }
}