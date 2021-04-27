package com.z80h3x.kezd_kov.data.orm

import androidx.room.Database
import androidx.room.RoomDatabase
import com.z80h3x.kezd_kov.data.orm.daos.CharacterDao
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter

@Database(entities = [RoomCharacter::class], exportSchema = true, version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}