package com.z80h3x.kezd_kov.data.network.apis

import com.z80h3x.kezd_kov.data.network.models.Character
import kotlinx.coroutines.delay
import javax.inject.Inject

class MockCharacterApi @Inject constructor() : IMockCharacterAPI {
    override suspend fun getAllCharacters(): Array<Character> {
        delay(500)
        return arrayOf(
            Character(name = "Salazar", id = "salazar", description = "human fighter"),
            Character(name = "Gary", id = "gary", description = "dwarf bloodhunter")
        )
    }

    override suspend fun addNewCharacter(character: Character) : Long {
        delay(1000)
        return 1
    }

    override suspend fun updateCharacter(character: Character) {
        delay(1000)
    }

    override suspend fun getCharacterById(characterId: String): Character {
        delay(500)
        return Character(name = "Salazar", id = "salazar", description = "human fighter")
    }

    override suspend fun deleteCharacter(characterId: String) {
        delay(1000)
    }


}