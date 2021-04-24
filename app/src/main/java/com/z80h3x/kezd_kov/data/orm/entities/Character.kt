package com.z80h3x.kezd_kov.data.orm.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
        @PrimaryKey val id : Int,
        @ColumnInfo(name = "cloudId") val cloudId: Int?,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "description") val description: String?,
        @ColumnInfo(name = "initiative") val initiative: Int,
        @ColumnInfo(name = "modifier") val modifier: Int
)
