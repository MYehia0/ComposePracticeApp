package com.example.composepracticeapp.features.profile.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composepracticeapp.features.profile.models.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(ProfileUiState())
    val state = _state.asStateFlow()

    fun onChangeFirstName(newValue: String) = _state.update {it.copy(firstName = newValue)}
    fun onChangeLastName(newValue: String) = _state.update {it.copy(lastName = newValue)}
    fun onChangeEmail(newValue: String) = _state.update {it.copy(email = newValue)}
    fun onChangePHone(newValue: String) = _state.update {it.copy(phone = newValue)}
    fun onChangeLocation(newValue: String) = _state.update {it.copy(location = newValue)}
    private fun onChangePictureLink(newValue: String) = _state.update {it.copy(link = newValue)}

    init {
        onChangePictureLink("https://img.icons8.com/?size=100&id=z-JBA_KtSkxG&format=png&color=000000")
    }
}