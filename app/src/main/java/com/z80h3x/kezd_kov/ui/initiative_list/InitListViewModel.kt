package com.z80h3x.kezd_kov.ui.initiative_list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import javax.inject.Inject

class InitListViewModel @Inject constructor(
    private val initListPresenter: InitListPresenter
) : RainbowCakeViewModel<InitListViewState>(Loading) {

    fun load() = execute {
        viewState = InitListReady(initListPresenter.getCharacters())
    }

    fun deleteCharacter(character: BaseCharacter) = execute {
        initListPresenter.deleteCharacter(character)
        load()
    }
}
