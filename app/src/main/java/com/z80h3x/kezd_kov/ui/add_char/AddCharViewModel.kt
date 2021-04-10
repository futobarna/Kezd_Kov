package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AddCharViewModel @Inject constructor(
    private val addCharPresenter: AddCharPresenter
) : RainbowCakeViewModel<AddCharViewState>(Loading) {

    fun load() = execute {
        viewState = AddCharReady(addCharPresenter.getData())
    }

}
