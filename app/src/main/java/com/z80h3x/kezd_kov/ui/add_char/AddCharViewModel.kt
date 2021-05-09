package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AddCharViewModel @Inject constructor(
    private val addCharPresenter: AddCharPresenter
) : RainbowCakeViewModel<AddCharViewState>(Form) {

    fun createCharacter(
        name: String,
        initiative: Int,
        modifier: Int,
        description: String?
    ) = execute {
        viewState = Loading
        val id = addCharPresenter.createCharacter(name, initiative, modifier, description)
        viewState = if (id != null){
            AddCharReady(id)
        } else {
            CharacterFailed
        }
    }

    fun getMonsterNames() = execute {
        viewState = Loading
        viewState = MonsterNamesReady(addCharPresenter.getMonsterNames())
    }

    fun getMonster(name: String) = execute {
        viewState = Loading
        viewState = MonsterReady(addCharPresenter.getMonster(name))
    }

}
