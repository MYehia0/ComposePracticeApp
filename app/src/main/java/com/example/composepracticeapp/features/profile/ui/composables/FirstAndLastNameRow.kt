package com.example.composepracticeapp.features.profile.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composepracticeapp.R
import com.example.composepracticeapp.core.ui.composables.CustomSpacer
import com.example.composepracticeapp.core.ui.composables.InformationCard

@Composable
fun FirstAndLastNameRow(firstName: String, lastName: String,onChangeFirstName: (value: String)->Unit,onChangeLastName: (value: String)->Unit) {
    Row (modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.weight(1f)){
            InformationCard(title = stringResource(id = R.string.first_name), information = firstName, onChange = onChangeFirstName)
        }
        CustomSpacer(horizontal = 8.dp)
        Box(modifier = Modifier.weight(1f)){
            InformationCard(title = stringResource(id = R.string.last_name), information = lastName, onChange = onChangeLastName)
        }
    }
}