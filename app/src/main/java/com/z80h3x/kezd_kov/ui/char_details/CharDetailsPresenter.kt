package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.orm.entities.Character
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class CharDetailsPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun getCharacter(characterId: Int): Character = withIOContext {
        characterInteractor.getCharacter(characterId)
    }

}
