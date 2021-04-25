package com.z80h3x.kezd_kov.data.orm.daos

import androidx.room.*
import com.z80h3x.kezd_kov.data.orm.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character")
    suspend fun getAll(): List<Character>

    @Query("SELECT * FROM character WHERE id = :characterId")
    suspend fun getCharacter(characterId: Int): Character

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character) : Long?

    @Delete
    suspend fun delete(character: Character)
}