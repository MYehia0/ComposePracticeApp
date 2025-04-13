package com.example.composepracticeapp.features.profile.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composepracticeapp.features.profile.presentation.models.ProfileUiState
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
    fun onChangePictureLink(newValue: String) = _state.update {it.copy(link = newValue)}

    init {
        onChangePictureLink("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fphotos%2Fclose-up-on-man-profile-looking-far-away&psig=AOvVaw2TgB_TynQLTkWeWLk_nD1I&ust=1744556659275000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNC7taKR1IwDFQAAAAAdAAAAABAE")
    }
}