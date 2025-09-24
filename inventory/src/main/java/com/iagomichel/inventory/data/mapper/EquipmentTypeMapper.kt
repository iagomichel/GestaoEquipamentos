package com.iagomichel.inventory.data.mapper

import com.iagomichel.inventory.data.local.entity.EquipmentTypeEntity
import com.iagomichel.inventory.domain.model.EquipmentTypeModel

fun EquipmentTypeEntity.toDomain(): EquipmentTypeModel {
    return when (this) {
        EquipmentTypeEntity.AR_CONDICIONADO -> EquipmentTypeModel.AR_CONDICIONADO
        EquipmentTypeEntity.CAFETEIRA -> EquipmentTypeModel.CAFETEIRA
        EquipmentTypeEntity.COMPUTADOR -> EquipmentTypeModel.COMPUTADOR
        EquipmentTypeEntity.MONITOR -> EquipmentTypeModel.MONITOR
        EquipmentTypeEntity.MOUSE -> EquipmentTypeModel.MOUSE
        EquipmentTypeEntity.TECLADO -> EquipmentTypeModel.TECLADO
        EquipmentTypeEntity.TELEVISAO -> EquipmentTypeModel.TELEVISAO
        EquipmentTypeEntity.ROTEADOR -> EquipmentTypeModel.ROTEADOR
    }
}

fun EquipmentTypeModel.toEntity(): EquipmentTypeEntity {
    return when (this) {
        EquipmentTypeModel.AR_CONDICIONADO -> EquipmentTypeEntity.AR_CONDICIONADO
        EquipmentTypeModel.CAFETEIRA -> EquipmentTypeEntity.CAFETEIRA
        EquipmentTypeModel.COMPUTADOR -> EquipmentTypeEntity.COMPUTADOR
        EquipmentTypeModel.MONITOR -> EquipmentTypeEntity.MONITOR
        EquipmentTypeModel.MOUSE -> EquipmentTypeEntity.MOUSE
        EquipmentTypeModel.TECLADO -> EquipmentTypeEntity.TECLADO
        EquipmentTypeModel.TELEVISAO -> EquipmentTypeEntity.TELEVISAO
        EquipmentTypeModel.ROTEADOR -> EquipmentTypeEntity.ROTEADOR
    }
}
