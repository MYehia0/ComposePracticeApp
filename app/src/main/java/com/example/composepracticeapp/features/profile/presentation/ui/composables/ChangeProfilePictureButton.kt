package com.example.composepracticeapp.features.profile.presentation.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composepracticeapp.R
import com.example.composepracticeapp.core.ui.theme.Orange

@Composable
fun ChangeProfilePictureButton (onClick : () -> Unit) {
    Text(
        text = stringResource(id = R.string.change_profile_picture),
        style = TextStyle(
            color = Orange,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        ),
        modifier = Modifier.clickable { onClick }
    )
}