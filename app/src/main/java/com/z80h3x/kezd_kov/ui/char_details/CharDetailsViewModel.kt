package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import javax.inject.Inject

class CharDetailsViewModel @Inject constructor(
    private val charDetailsPresenter: CharDetailsPresenter
) : RainbowCakeViewModel<CharDetailsViewState>(Loading) {

    fun load(id: Long) = execute {
        viewState = CharDetailsReady(charDetailsPresenter.getCharacter(id))
    }

    fun updateCharacter(character: BaseCharacter) = execute {
        charDetailsPresenter.updateCharacter(character)
    }
}
