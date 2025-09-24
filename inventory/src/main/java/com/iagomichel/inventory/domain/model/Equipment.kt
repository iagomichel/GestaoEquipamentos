package com.iagomichel.inventory.domain.model

data class Equipment(
    val code: String,
    val name: String,
    val brand: String,
    val type: EquipmentTypeModel,
    val obs: String? = null,
    val photoUrl: String? = null,
    val locationId: Int? = null
)

enum class EquipmentTypeModel(val description: String) {
    AR_CONDICIONADO("Ar Condicionado"),
    CAFETEIRA("Cafeteira"),
    COMPUTADOR("Computador"),
    MONITOR("Monitor"),
    MOUSE("Mouse"),
    TECLADO("Teclado"),
    TELEVISAO("Televisão"),
    ROTEADOR("Roteador");

    override fun toString(): String = description
}
