package com.z80h3x.kezd_kov.data.orm.daos

import androidx.room.*
import com.z80h3x.kezd_kov.data.orm.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    suspend fun getALL(): List<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character)

    @Delete
    suspend fun delete(character: Character)
}