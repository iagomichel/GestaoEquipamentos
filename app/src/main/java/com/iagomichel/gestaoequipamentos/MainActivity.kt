package com.iagomichel.gestaoequipamentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iagomichel.gestaoequipamentos.ui.theme.GestaoEquipamentosTheme
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.presentation.ui.EquipmentFormScreen
import com.iagomichel.inventory.presentation.ui.list.EquipmentScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestaoEquipamentosTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(0) }
    var selectedEquipment by remember { mutableStateOf<Equipment?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        selectedEquipment = null
                    },
                    label = { Text("Cadastrar") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "Cadastrar") }
                )
                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        selectedEquipment = null
                    },
                    label = { Text("Consultar") },
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Consultar") }
                )
            }
        }
    ) { innerPadding ->
        when (selectedIndex) {
            0 -> EquipmentFormScreen(
                modifier = Modifier.padding(innerPadding),
                equipment = selectedEquipment
            )
            1 -> EquipmentScreen(
                modifier = Modifier.padding(innerPadding),
                onEquipmentSelected = { equipment ->
                    selectedEquipment = equipment
                    selectedIndex = 0
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestaoEquipamentosTheme {
        MainScreen()
    }
}
