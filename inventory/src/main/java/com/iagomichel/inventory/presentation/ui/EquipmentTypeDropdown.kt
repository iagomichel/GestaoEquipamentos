package com.iagomichel.inventory.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.iagomichel.inventory.domain.model.EquipmentTypeModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdownMenu(
    currentTypeSelected: EquipmentTypeModel?,
    onEquipmentTypeSelected: (equipmentTypeSelected: EquipmentTypeModel) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(currentTypeSelected) }

    val options = EquipmentTypeModel.entries.toList()

    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedOption?.description.orEmpty(),
                onValueChange = {},
                readOnly = true,
                label = { Text("Tipo de equipamento") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.description) },
                        onClick = {
                            selectedOption = option
                            expanded = false
                            onEquipmentTypeSelected(option)
                        }
                    )
                }
            }
        }
    }
}

