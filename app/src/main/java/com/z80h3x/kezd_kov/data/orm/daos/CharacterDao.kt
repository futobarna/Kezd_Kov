package com.z80h3x.kezd_kov.data.orm.daos

import androidx.room.*
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter

@Dao
interface CharacterDao {
    @Query("SELECT * FROM roomcharacter")
    suspend fun getAll(): List<RoomCharacter>

    @Query("SELECT * FROM roomcharacter WHERE id = :characterId")
    suspend fun getCharacter(characterId: Long): RoomCharacter

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: RoomCharacter) : Long?

    @Delete
    suspend fun delete(character: RoomCharacter)
}