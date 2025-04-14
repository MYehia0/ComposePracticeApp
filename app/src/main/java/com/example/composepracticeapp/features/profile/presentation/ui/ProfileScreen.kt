package com.example.composepracticeapp.features.profile.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composepracticeapp.R
import com.example.composepracticeapp.core.ui.composables.CustomSpacer
import com.example.composepracticeapp.features.profile.presentation.ui.composables.Header
import com.example.composepracticeapp.core.ui.theme.ComposePracticeAppTheme
import com.example.composepracticeapp.features.profile.presentation.models.ProfileUiState
import com.example.composepracticeapp.features.profile.presentation.ui.composables.ChangeProfilePictureButton
import com.example.composepracticeapp.features.profile.presentation.ui.composables.FirstAndLastNameRow
import com.example.composepracticeapp.features.profile.presentation.ui.composables.InformationCard
import com.example.composepracticeapp.features.profile.presentation.ui.composables.ProfileAvatar
import com.example.composepracticeapp.features.profile.presentation.ui.composables.SaveButton
import com.example.composepracticeapp.features.profile.presentation.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.collectAsState()
    ProfileContent(
        modifier = modifier,
        state = state.value,
        onChangeFirstName = viewModel::onChangeFirstName,
        onChangeLastName = viewModel::onChangeLastName,
        onChangeEmail = viewModel::onChangeEmail,
        onChangePhone = viewModel::onChangePHone,
        onChangeLocation = viewModel::onChangeLocation,
        onCLickChangeProfilePicture = {},
        onCLickSave = {},
    )
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    state: ProfileUiState,
    onChangeFirstName: (value: String) -> Unit,
    onChangeLastName: (value: String) -> Unit,
    onChangeEmail: (value: String) -> Unit,
    onChangePhone: (value: String) -> Unit,
    onChangeLocation: (value: String) -> Unit,
    onCLickChangeProfilePicture: () -> Unit,
    onCLickSave: () -> Unit,
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(title = stringResource(id = R.string.account), subtitle = stringResource(id = R.string.edit_and_manage_your_account))
        CustomSpacer(vertical = 32.dp)
        ProfileAvatar(painter = rememberAsyncImagePainter(model = state.link)) // painterResource(id = R.drawable.profile)
        CustomSpacer(vertical = 24.dp)
        ChangeProfilePictureButton(onClick = onCLickChangeProfilePicture)
        CustomSpacer(vertical = 32.dp)
        FirstAndLastNameRow(firstName = state.firstName, lastName = state.lastName, onChangeFirstName = onChangeFirstName, onChangeLastName = onChangeLastName)
        InformationCard(title = stringResource(id = R.string.email), information = state.email, onChange = onChangeEmail)
        InformationCard(title = stringResource(id = R.string.phone), information = state.phone, onChange = onChangePhone)
        InformationCard(title = stringResource(id = R.string.location), information = state.location, onChange = onChangeLocation)
        Spacer(modifier = Modifier.weight(1f))
        SaveButton(onClick = onCLickSave)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ComposePracticeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ProfileScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}