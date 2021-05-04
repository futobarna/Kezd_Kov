package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class AddCharPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun createCharacter(
        name: String,
        initiative: Int,
        modifier: Int
    ): Long? = withIOContext {
        return@withIOContext characterInteractor.insertCharacter(BaseCharacter(null, null, name, null, initiative, modifier))
    }

}
