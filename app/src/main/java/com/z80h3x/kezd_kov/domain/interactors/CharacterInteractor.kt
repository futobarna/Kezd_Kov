package com.z80h3x.kezd_kov.domain.interactors

import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.network.NetworkDataSource
import com.z80h3x.kezd_kov.data.network.models.Monster
import com.z80h3x.kezd_kov.data.network.models.MonsterList
import com.z80h3x.kezd_kov.data.orm.DiskDataSource
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
        private val diskDataSource: DiskDataSource,
        private val networkDataSource: NetworkDataSource
) {
    suspend fun getCharacterList(): MutableList<RoomCharacter>{
        return diskDataSource.getCharacterList()
    }

    suspend fun getCharacter(characterId: Long): RoomCharacter{
        return diskDataSource.getCharacter(characterId)
    }

    suspend fun insertCharacter(character: RoomCharacter): Long?{
        return diskDataSource.insertCharacter(character)
    }

    suspend fun deleteCharacter(character: RoomCharacter){
        diskDataSource.deleteCharacter(character)
    }

    suspend fun getAllMonsters(): MonsterList {
        return networkDataSource.getAllMonsters()
    }

    suspend fun getMonsterByName(monsterName: String): Monster {
        return networkDataSource.getMonsterByName(monsterName)
    }

    suspend fun getAllCharacters(): Array<BaseCharacter> {
        return networkDataSource.getAllCharacters()
    }

    suspend fun addNewCharacter(character: BaseCharacter) : Long {
        return networkDataSource.addNewCharacter(character)
    }

    suspend fun updateCharacter(character: BaseCharacter) {
        networkDataSource.updateCharacter(character)
    }

    suspend fun getCharacterById(characterId: Long): BaseCharacter {
        return networkDataSource.getCharacterById(characterId)
    }

    suspend fun deleteCharacter(characterId: Long) {
        networkDataSource.deleteCharacter(characterId)
    }
}