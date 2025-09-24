package com.iagomichel.inventory.domain.usecase

import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.repository.EquipmentRepository

class SaveEquipmentUseCaseImpl(
    private val repository: EquipmentRepository
): SaveEquipmentUseCase {

    override suspend fun invoke(equipment: Equipment) {
        repository.saveEquipment(equipment)
    }
}
