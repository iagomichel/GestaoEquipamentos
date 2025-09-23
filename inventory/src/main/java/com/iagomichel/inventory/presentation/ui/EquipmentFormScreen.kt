package com.iagomichel.inventory.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EquipmentFormScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Tela de iago",
        modifier = modifier
    )
}

@Preview
@Composable
private fun EquipmentFormScreenPreview() {
    EquipmentFormScreen()
}