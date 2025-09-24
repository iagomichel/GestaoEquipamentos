package com.iagomichel.inventory.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagomichel.inventory.data.local.entity.EquipmentTypeEntity
import com.iagomichel.inventory.data.mapper.toDomain
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.domain.usecase.SaveEquipmentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipmentFormViewModel @Inject constructor(
    private val saveEquipmentUseCase: SaveEquipmentUseCase
): ViewModel() {
    fun save(
        code: String,
        name: String,
        brand: String,
        type: EquipmentTypeEntity,
        obs: String,
        photoUri: String
    ) {
        viewModelScope.launch {
            val equipment = Equipment(code, name, brand, type.toDomain(), obs)
            saveEquipmentUseCase(equipment)
        }
    }
}
