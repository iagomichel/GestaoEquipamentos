package com.iagomichel.inventory.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.iagomichel.inventory.data.local.dao.EquipmentDao
import com.iagomichel.inventory.data.local.entity.EquipmentEntity
import com.iagomichel.inventory.data.mapper.toDomain
import com.iagomichel.inventory.data.mapper.toEntity
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.repository.EquipmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EquipmentRepositoryImpl(
    private val dao: EquipmentDao
) : EquipmentRepository {

    override suspend fun saveEquipment(equipment: Equipment) {
        val entity = EquipmentEntity(
            code = equipment.code,
            name = equipment.name,
            brand = equipment.brand,
            type = equipment.type.toEntity(),
            obs = equipment.obs
        )
        dao.insertEquipment(entity)
    }

    override fun getFilteredEquipments(query: String): Flow<PagingData<Equipment>> {
        return Pager(
            config = PagingConfig(pageSize = 2, enablePlaceholders = false),
            pagingSourceFactory = { dao.getFilteredEquipmentsPaging("%$query%") }
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                Equipment(
                    code = entity.code,
                    name = entity.name,
                    brand = entity.brand,
                    type = entity.type.toDomain(),
                    obs = entity.obs
                )
            }
        }
    }
}
