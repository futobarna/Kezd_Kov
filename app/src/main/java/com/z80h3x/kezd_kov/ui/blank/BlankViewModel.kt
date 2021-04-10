package com.z80h3x.kezd_kov.ui.blank

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class BlankViewModel @Inject constructor(
    private val blankPresenter: BlankPresenter
) : RainbowCakeViewModel<BlankViewState>(Loading) {

    fun load() = execute {
        viewState = BlankReady(blankPresenter.getData())
    }

}
