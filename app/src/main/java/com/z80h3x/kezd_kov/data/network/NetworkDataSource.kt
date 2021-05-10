package com.z80h3x.kezd_kov.data.network

import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.network.apis.DnD5eAPI
import com.z80h3x.kezd_kov.data.network.apis.MockCharacterApi
import com.z80h3x.kezd_kov.data.network.models.Character
import com.z80h3x.kezd_kov.data.network.models.Monster
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.floor

@Singleton
class NetworkDataSource @Inject constructor(
    private val dnd5eAPI: DnD5eAPI,
    private val mockCharacterApi: MockCharacterApi,
){
    suspend fun getAllMonsters(): MutableList<String>{
        val allMonsters = dnd5eAPI.getAllMonsters()
        val monsterNames : MutableList<String> = arrayListOf()
        allMonsters.results?.forEach {
            it.name?.let { it1 -> monsterNames.add(it1) }
        }
        return monsterNames
    }

    suspend fun getMonsterByName(monsterName: String): BaseCharacter {
        val monster = dnd5eAPI.getMonsterByName(monsterName)
        return BaseCharacter(id = null, cloudId = null, name = monster.name!!,
                description = monster.createDescription(), initiative = null,
                modifier = floor((monster.dexterity!! - 10) / 2.0).toInt()
        )
    }

    suspend fun getAllCharacters(): MutableList<String> {
        val chars = mockCharacterApi.getAllCharacters()
        val list : MutableList<String> = arrayListOf()
        chars.forEach {
            list.add(it.name)
        }
        return list
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

    suspend fun getCharacterById(characterId: String): BaseCharacter {
        val char = mockCharacterApi.getCharacterById(characterId)
        return BaseCharacter(id = null, cloudId = characterId, name = char.name,
            description = char.description, initiative = null, modifier = null)
    }

    suspend fun deleteCharacter(characterId: String) {
        mockCharacterApi.deleteCharacter(characterId)
    }
}