package com.example.composepracticeapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.composepracticeapp.core.nav.AppNavigation
import com.example.composepracticeapp.core.ui.theme.ComposePracticeAppTheme
import com.example.composepracticeapp.features.profile.ui.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeApp()
        }
    }
}

@Composable
fun ComposePracticeApp() {
    ComposePracticeAppTheme(darkTheme = false) {
        AppNavigation()
    }
}

