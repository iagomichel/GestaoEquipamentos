package com.iagomichel.inventory.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipments")
data class EquipmentEntity(
    @PrimaryKey val code: String,
    val name: String,
    val brand: String,
    val type: EquipmentTypeEntity,
    val obs: String? = null,
    val photoUri: String? = null,
    val locationId: Int? = null
)

enum class EquipmentTypeEntity {
    AR_CONDICIONADO,
    CAFETEIRA,
    COMPUTADOR,
    MONITOR,
    MOUSE,
    TECLADO,
    TELEVISAO,
    ROTEADOR
}

