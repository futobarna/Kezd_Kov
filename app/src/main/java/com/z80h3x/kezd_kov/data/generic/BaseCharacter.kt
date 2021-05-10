package com.z80h3x.kezd_kov.data.generic

data class BaseCharacter(
    val id : Long?,
    val cloudId: String?,
    val name: String,
    val description: String?,
    val initiative: Int?,
    val modifier: Int?
)
