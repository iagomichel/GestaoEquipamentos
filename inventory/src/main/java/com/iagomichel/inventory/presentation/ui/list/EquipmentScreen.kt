package com.iagomichel.inventory.presentation.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.domain.model.EquipmentTypeModel
import com.iagomichel.inventory.presentation.ui.EquipmentSearchViewModel

@Composable
fun EquipmentScreen(
    modifier: Modifier = Modifier,
    viewModel: EquipmentSearchViewModel = hiltViewModel(),
    onEquipmentSelected: (equipment: Equipment) -> Unit
) {
    val equipmentsPaging = viewModel.equipments.collectAsLazyPagingItems()
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                viewModel.onQueryChanged(it)
            },
            label = { Text("Pesquisar equipamento") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(equipmentsPaging.itemCount) { index ->
                equipmentsPaging[index]?.let { equipment ->
                    EquipmentCard(equipment, onEquipmentSelected)
                }
            }

            equipmentsPaging.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            Box(
                                Modifier.fillParentMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally)) }
                    }
                    loadState.append is LoadState.Error -> {
                        val e = loadState.append as LoadState.Error
                        item { Text("Erro: ${e.error.localizedMessage}") }
                    }
                }
            }
        }
    }
}

@Composable
fun EquipmentCard(
    equipment: Equipment,
    onEquipmentSelected: (equipment: Equipment) -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            onEquipmentSelected(equipment)
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = equipment.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Marca: ${equipment.brand}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Código: ${equipment.code}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Tipo: ${equipment.type.description.lowercase().replaceFirstChar { it.uppercase() }}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (equipment.obs.isNullOrEmpty()) {
                Text(
                    text = "Observação: ${equipment.obs}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EquipmentScreenPreviewLight() {
    val sampleEquipments = listOf(
        Equipment(
            code = "001",
            name = "Iago",
            brand = "Dell",
            type = EquipmentTypeModel.COMPUTADOR,
            obs = "Em bom estado"
        ),
        Equipment(
            code = "002",
            name = "Produttivo",
            brand = "Logitech",
            type = EquipmentTypeModel.MOUSE,
            obs = "Sem fio"
        ),
        Equipment(
            code = "003",
            name = "Externo",
            brand = "Microsoft",
            type = EquipmentTypeModel.TECLADO,
            obs = "Mecânico"
        )
    )

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Pesquisar equipamento") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(sampleEquipments.size) { index ->
                EquipmentCard(sampleEquipments[index], {} )
            }
        }
    }
}

