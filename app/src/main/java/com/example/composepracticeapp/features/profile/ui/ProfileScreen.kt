package com.example.composepracticeapp.features.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.composepracticeapp.R
import com.example.composepracticeapp.core.nav.Screen
import com.example.composepracticeapp.core.ui.composables.CustomSpacer
import com.example.composepracticeapp.core.ui.composables.Header
import com.example.composepracticeapp.core.ui.theme.ComposePracticeAppTheme
import com.example.composepracticeapp.features.profile.models.ProfileUiState
import com.example.composepracticeapp.core.ui.composables.CustomButton
import com.example.composepracticeapp.features.profile.ui.composables.FirstAndLastNameRow
import com.example.composepracticeapp.core.ui.composables.InformationCard
import com.example.composepracticeapp.features.profile.ui.composables.ProfileAvatar
import com.example.composepracticeapp.core.ui.composables.TextButton
import com.example.composepracticeapp.features.profile.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.collectAsState()

    Scaffold { innerPadding ->
        ProfileContent(
            modifier = modifier.fillMaxSize().padding(innerPadding).verticalScroll(rememberScrollState()),
            state = state.value,
            onChangeFirstName = viewModel::onChangeFirstName,
            onChangeLastName = viewModel::onChangeLastName,
            onChangeEmail = viewModel::onChangeEmail,
            onChangePhone = viewModel::onChangePHone,
            onChangeLocation = viewModel::onChangeLocation,
            onCLickChangeProfilePicture = {},
            onCLickSave = {},
            onCLickNext = { navController.navigate(Screen.Food.route) }
        )
    }
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
    onCLickNext: () -> Unit,
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Header(title = stringResource(id = R.string.account), subtitle = stringResource(id = R.string.edit_and_manage_your_account), modifier =  Modifier)
            CustomButton(text = stringResource(id = R.string.next), onClick = onCLickNext, modifier = Modifier)
        }
        CustomSpacer(vertical = 32.dp)
        ProfileAvatar(painter = rememberAsyncImagePainter(model = state.link)) // painterResource(id = R.drawable.profile)
        CustomSpacer(vertical = 24.dp)
        TextButton(text = stringResource(id = R.string.change_profile_picture), onClick = onCLickChangeProfilePicture)
        CustomSpacer(vertical = 32.dp)
        FirstAndLastNameRow(firstName = state.firstName, lastName = state.lastName, onChangeFirstName = onChangeFirstName, onChangeLastName = onChangeLastName)
        InformationCard(title = stringResource(id = R.string.email), information = state.email, onChange = onChangeEmail)
        InformationCard(title = stringResource(id = R.string.phone), information = state.phone, onChange = onChangePhone)
        InformationCard(title = stringResource(id = R.string.location), information = state.location, onChange = onChangeLocation)
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(text = stringResource(id = R.string.save), onClick = onCLickSave)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ComposePracticeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ProfileScreen(
                navController = NavHostController(LocalContext.current),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}