package com.iagomichel.inventory.domain.usecase

import com.iagomichel.inventory.domain.model.Equipment

interface SaveEquipmentUseCase {
    suspend operator fun invoke(equipment: Equipment)
}