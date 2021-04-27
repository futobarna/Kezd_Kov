package com.z80h3x.kezd_kov.data.orm

import android.content.Context
import com.z80h3x.kezd_kov.data.orm.daos.CharacterDao
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
        private val characterDao: CharacterDao
        ) {
    suspend fun getCharacterList() : MutableList<RoomCharacter> {
        return characterDao.getAll().toMutableList()
    }

    suspend fun getCharacter(characterId: Long) : RoomCharacter {
        return characterDao.getCharacter(characterId)
    }

    suspend fun insertCharacter(character: RoomCharacter) : Long? {
        return characterDao.insert(character)
    }

    suspend fun deleteCharacter(character: RoomCharacter) {
        characterDao.delete(character)
    }
}