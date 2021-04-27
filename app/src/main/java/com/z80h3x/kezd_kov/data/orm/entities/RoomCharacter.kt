package com.z80h3x.kezd_kov.data.orm.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomCharacter(
        @PrimaryKey(autoGenerate = true) val id : Long?,
        @ColumnInfo(name = "cloudId") val cloudId: Long?,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "description") val description: String?,
        @ColumnInfo(name = "initiative") val initiative: Int,
        @ColumnInfo(name = "modifier") val modifier: Int
)
