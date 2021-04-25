package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class CharDetailsViewModel @Inject constructor(
    private val charDetailsPresenter: CharDetailsPresenter
) : RainbowCakeViewModel<CharDetailsViewState>(Loading) {

    fun load(id: Int) = execute {
        viewState = CharDetailsReady(charDetailsPresenter.getCharacter(id))
    }

}
