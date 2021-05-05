package com.z80h3x.kezd_kov.ui.initiative_list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import javax.inject.Inject

class InitListViewModel @Inject constructor(
    private val initListPresenter: InitListPresenter
) : RainbowCakeViewModel<InitListViewState>(Loading) {

    fun load(orderDescending: Boolean) = execute {
        val sortedList = if (orderDescending) initListPresenter.getCharacters().sortedWith(
            compareBy<BaseCharacter> { it.initiative }
                .thenBy { it.modifier }
        ).reversed().toMutableList()
        else initListPresenter.getCharacters().sortedWith(
            compareBy<BaseCharacter> { it.initiative }
                .thenBy { it.modifier }
        ).toMutableList()
        viewState = InitListReady(sortedList)
    }

    fun deleteCharacter(character: BaseCharacter, sortDescending: Boolean) = execute {
        initListPresenter.deleteCharacter(character)
        load(sortDescending)
    }
}
