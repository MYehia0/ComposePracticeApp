package com.example.composepracticeapp.features.profile.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepracticeapp.R

@Composable
fun ProfileAvatar(painter: Painter) {
    Image(
        painter = painter,
        contentDescription = "Profile Image",
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileAvatarPreview() {
    ProfileAvatar(
        painter = painterResource(id = R.drawable.profile)
    )
}