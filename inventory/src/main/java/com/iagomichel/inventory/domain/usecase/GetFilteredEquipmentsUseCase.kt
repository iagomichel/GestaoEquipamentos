package com.iagomichel.inventory.domain.usecase

import androidx.paging.PagingData
import com.iagomichel.inventory.domain.model.Equipment
import kotlinx.coroutines.flow.Flow

interface GetFilteredEquipmentsUseCase {
    operator fun invoke(query: String): Flow<PagingData<Equipment>>
}
