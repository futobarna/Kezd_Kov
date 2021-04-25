package com.z80h3x.kezd_kov.ui.initiative_list

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.orm.entities.Character
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class InitListPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun getCharacters(): MutableList<Character> = withIOContext {
        characterInteractor.getCharacterList()
    }

    suspend fun deleteCharacter(character: Character) = withIOContext {
        characterInteractor.deleteCharacter(character)
    }

}
