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
    suspend fun getCharacterList(): MutableList<BaseCharacter>{
        return diskDataSource.getCharacterList()
    }

    suspend fun getCharacter(characterId: Long): BaseCharacter{
        return diskDataSource.getCharacter(characterId)
    }

    suspend fun insertCharacter(character: BaseCharacter): Long?{
        return diskDataSource.insertCharacter(character)
    }

    suspend fun deleteCharacter(character: BaseCharacter){
        diskDataSource.deleteCharacter(character)
    }

    suspend fun getAllMonsters(): MutableList<String> {
        return networkDataSource.getAllMonsters()
    }

    suspend fun getMonsterByName(monsterName: String): BaseCharacter {
        return networkDataSource.getMonsterByName(monsterName)
    }

    suspend fun getAllCloudCharacters(): MutableList<String> {
        return networkDataSource.getAllCharacters()
    }

    suspend fun addNewCloudCharacter(character: BaseCharacter) : Long {
        return networkDataSource.addNewCharacter(character)
    }

    suspend fun updateCloudCharacter(character: BaseCharacter) {
        networkDataSource.updateCharacter(character)
    }

    suspend fun getCloudCharacterById(characterId: String): BaseCharacter {
        return networkDataSource.getCharacterById(characterId)
    }

    suspend fun deleteCloudCharacter(characterId: String) {
        networkDataSource.deleteCharacter(characterId)
    }
}