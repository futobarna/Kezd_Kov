package com.z80h3x.kezd_kov.data.network

import android.content.Context
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.network.apis.DnD5eAPI
import com.z80h3x.kezd_kov.data.network.apis.MockCharacterApi
import com.z80h3x.kezd_kov.data.network.models.Character
import com.z80h3x.kezd_kov.data.network.models.Monster
import com.z80h3x.kezd_kov.data.network.models.MonsterList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val dnd5eAPI: DnD5eAPI,
    private val mockCharacterApi: MockCharacterApi,
){
    suspend fun getAllMonsters(): MonsterList{
        return dnd5eAPI.getAllMonsters()
    }

    suspend fun getMonsterByName(monsterName: String): Monster {
        return dnd5eAPI.getMonsterByName(monsterName)
    }

    suspend fun getAllCharacters(): Array<BaseCharacter> {
        val chars = mockCharacterApi.getAllCharacters()
        val array : MutableList<BaseCharacter> = arrayListOf()
        chars.forEach {
            array.add(
                BaseCharacter(id = null, cloudId = it.id, name = it.name,
                    description = it.description, initiative = null, modifier = null)
            )
        }
        return array.toTypedArray()
    }

    suspend fun addNewCharacter(character: BaseCharacter) : Long {
        return mockCharacterApi.addNewCharacter(
            Character(id = null, name = character.name, description = character.description)
        )
    }

    suspend fun updateCharacter(character: BaseCharacter) {
        mockCharacterApi.updateCharacter(
            Character(id = character.cloudId, name = character.name, description = character.description)
        )
    }

    suspend fun getCharacterById(characterId: Long): BaseCharacter {
        val char = mockCharacterApi.getCharacterById(characterId)
        return BaseCharacter(id = null, cloudId = characterId, name = char.name,
            description = char.description, initiative = null, modifier = null)
    }

    suspend fun deleteCharacter(characterId: Long) {
        mockCharacterApi.deleteCharacter(characterId)
    }
}