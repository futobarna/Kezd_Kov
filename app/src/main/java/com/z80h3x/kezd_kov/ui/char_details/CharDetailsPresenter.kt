package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class CharDetailsPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun getCharacter(characterId: Long): BaseCharacter = withIOContext {
        characterInteractor.getCharacter(characterId)
    }

    suspend fun updateCharacter(character: BaseCharacter) = withIOContext {
        characterInteractor.insertCharacter(character)
    }

    suspend fun saveToCloud(character: BaseCharacter): String = withIOContext {
        if (character.cloudId == null)
            return@withIOContext characterInteractor.addNewCloudCharacter(character)
        else
            return@withIOContext characterInteractor.updateCloudCharacter(character)
    }

    suspend fun deleteFromCloud(characterId: String) = withIOContext {
        characterInteractor.deleteCloudCharacter(characterId)
    }
}
