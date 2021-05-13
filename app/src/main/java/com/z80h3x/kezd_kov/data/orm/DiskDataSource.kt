package com.z80h3x.kezd_kov.data.orm

import android.content.Context
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.daos.CharacterDao
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
        private val characterDao: CharacterDao
        ) {
    suspend fun getCharacterList() : MutableList<BaseCharacter> {
        val chars = characterDao.getAll()
        val array : MutableList<BaseCharacter> = arrayListOf()
        chars.forEach {
            array.add(
                    BaseCharacter(id = it.id, cloudId = it.cloudId, name = it.name,
                            description = it.description, initiative = it.initiative,
                            modifier = it.modifier
                    )
            )
        }
        return array
    }

    suspend fun getCharacter(characterId: Long) : BaseCharacter {
        val char = characterDao.getCharacter(characterId)
        return BaseCharacter(id = char.id, cloudId = char.cloudId, name = char.name,
            description = char.description, initiative = char.initiative, modifier = char.modifier)
    }

    suspend fun insertCharacter(character: BaseCharacter) : Long? {
        return characterDao.insert(RoomCharacter(id = character.id, cloudId = character.cloudId,
                name = character.name, description = character.description,
                initiative = character.initiative!!, modifier = character.modifier!!))
    }

    suspend fun deleteCharacter(character: BaseCharacter) {
        characterDao.delete(RoomCharacter(id = character.id, cloudId = character.cloudId,
                name = character.name, description = character.description,
                initiative = character.initiative!!, modifier = character.modifier!!))
    }
}