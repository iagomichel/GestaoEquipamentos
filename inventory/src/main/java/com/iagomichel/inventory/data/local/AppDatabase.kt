package com.iagomichel.inventory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iagomichel.inventory.data.local.dao.EquipmentDao
import com.iagomichel.inventory.data.local.entity.EquipmentEntity

@Database(
    entities = [EquipmentEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun equipmentDao(): EquipmentDao
}
