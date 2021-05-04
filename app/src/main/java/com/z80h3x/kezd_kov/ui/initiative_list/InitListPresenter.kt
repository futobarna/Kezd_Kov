package com.z80h3x.kezd_kov.ui.initiative_list

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class InitListPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun getCharacters(): MutableList<BaseCharacter> = withIOContext {
        characterInteractor.getCharacterList()
    }

    suspend fun deleteCharacter(character: BaseCharacter) = withIOContext {
        characterInteractor.deleteCharacter(character)
    }

}
