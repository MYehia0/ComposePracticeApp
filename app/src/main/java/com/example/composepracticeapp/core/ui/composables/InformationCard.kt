package com.example.composepracticeapp.core.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InformationCard(
    title: String,
    information: String,
    modifierCard: Modifier = Modifier,
    modifierColumn: Modifier = Modifier,
    modifierTextField: Modifier = Modifier,
    onChange: (value: String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.LightGray.copy(alpha = 0.5f)),
        modifier = modifierCard
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column (modifier = modifierColumn.fillMaxWidth().padding(vertical = 16.dp, horizontal = 12.dp)) {
            Text(
                text = title,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 10.sp
                )
            )
            BasicTextField(
                value = information,
                onValueChange = onChange,
                modifier = modifierTextField.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InformationCardPreview() {
    InformationCard(
        title = "Account",
        information = "Edit and Manage your account"
    ) {}
}