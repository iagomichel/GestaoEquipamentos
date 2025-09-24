package com.iagomichel.inventory.data.mapper

import com.iagomichel.inventory.data.local.entity.EquipmentEntity
import com.iagomichel.inventory.domain.model.Equipment

fun EquipmentEntity.toModel(): Equipment {
    return Equipment(
        code = code,
        name = name,
        brand = brand,
        type = type.toDomain(),
        obs = obs,
        photoUrl = photoUri,
        locationId = locationId
    )
}

fun Equipment.toEntity(): EquipmentEntity {
    return EquipmentEntity(
        code = code,
        name = name,
        brand = brand,
        type = type.toEntity(),
        obs = obs,
        photoUri = photoUrl,
        locationId = locationId
    )
}

