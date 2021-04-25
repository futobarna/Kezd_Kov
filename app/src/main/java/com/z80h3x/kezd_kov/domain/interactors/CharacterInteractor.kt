package com.z80h3x.kezd_kov.domain.interactors

import com.z80h3x.kezd_kov.data.orm.DiskDataSource
import com.z80h3x.kezd_kov.data.orm.entities.Character
import javax.inject.Inject

class CharacterInteractor @Inject constructor(
        private val diskDataSource: DiskDataSource
) {
    suspend fun getCharacterList(): MutableList<Character>{
        return diskDataSource.getCharacterList()
    }

    suspend fun getCharacter(characterId: Int): Character{
        return diskDataSource.getCharacter(characterId)
    }

    suspend fun insertCharacter(character: Character): Long?{
        return diskDataSource.insertCharacter(character)
    }

    suspend fun deleteCharacter(character: Character){
        diskDataSource.deleteCharacter(character)
    }
}