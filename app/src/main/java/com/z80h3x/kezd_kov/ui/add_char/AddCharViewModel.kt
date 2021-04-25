package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AddCharViewModel @Inject constructor(
    private val addCharPresenter: AddCharPresenter
) : RainbowCakeViewModel<AddCharViewState>(Form) {

    fun createCharacter(
        name: String,
        initiative: Int,
        modifier: Int
    ) = execute {
        viewState = Loading
        val id = addCharPresenter.createCharacter(name, initiative, modifier)
        viewState = if (id != null){
            AddCharReady(id)
        } else {
            CharacterFailed
        }
    }

}
