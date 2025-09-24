package com.iagomichel.inventory.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iagomichel.inventory.data.local.entity.EquipmentEntity

@Dao
interface EquipmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipment(equipment: EquipmentEntity)

    @Query("""
        SELECT * FROM equipments
        WHERE name LIKE :query OR brand LIKE :query OR type LIKE :query OR obs LIKE :query
        ORDER BY name ASC
    """)
    fun getFilteredEquipmentsPaging(query: String): PagingSource<Int, EquipmentEntity>
}
