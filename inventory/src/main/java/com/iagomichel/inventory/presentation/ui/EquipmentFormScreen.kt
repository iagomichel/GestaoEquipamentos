package com.iagomichel.inventory.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.iagomichel.inventory.data.mapper.toEntity
import com.iagomichel.inventory.domain.model.Equipment

@Composable
fun EquipmentFormScreen(
    modifier: Modifier = Modifier,
    viewModel: EquipmentFormViewModel = hiltViewModel(),
    equipment: Equipment? = null
) {
    var code by remember { mutableStateOf(equipment?.code.orEmpty()) }
    var name by remember { mutableStateOf(equipment?.name.orEmpty()) }
    var brand by remember { mutableStateOf(equipment?.brand.orEmpty()) }
    var type by remember { mutableStateOf(equipment?.type) }
    var notes by remember { mutableStateOf(equipment?.obs.orEmpty()) }
    var photoUri by remember { mutableStateOf(equipment?.photoUrl) }
    val context = LocalContext.current

    var loading by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (equipment != null) "Edição" else "Cadastro",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = code,
                    onValueChange = { code = it },
                    singleLine = true,
                    label = { Text("Código") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    singleLine = true,
                    label = { Text("Nome") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = brand,
                    onValueChange = { brand = it },
                    singleLine = true,
                    label = { Text("Marca") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))

                SimpleDropdownMenu(
                    currentTypeSelected = equipment?.type,
                    onEquipmentTypeSelected = { selected ->
                        type = selected
                    },
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    singleLine = true,
                    label = { Text("Observações") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        if (type == null) {
                            Toast.makeText(
                                context,
                                "Selecione uma opção de equipamento",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@Button
                        }
                        loading = true
                        viewModel.save(
                            code = code,
                            name = name,
                            brand = brand,
                            type = type!!.toEntity(),
                            obs = notes,
                            photoUri = photoUri.orEmpty()
                        )
                        loading = false
                        Toast.makeText(
                            context,
                            "Gravado com sucesso!",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    Text(text = "Salvar")
                }
            }

        }
    }
}

