package com.iagomichel.inventory.domain.usecase

import androidx.paging.PagingData
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.repository.EquipmentRepository
import kotlinx.coroutines.flow.Flow

class GetFilteredEquipmentsUseCaseImpl(
    private val repository: EquipmentRepository
) : GetFilteredEquipmentsUseCase {

    override fun invoke(query: String): Flow<PagingData<Equipment>> {
        return repository.getFilteredEquipments(query)
    }
}
