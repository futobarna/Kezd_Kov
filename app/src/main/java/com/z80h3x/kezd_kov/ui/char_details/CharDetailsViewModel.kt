package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import javax.inject.Inject

class CharDetailsViewModel @Inject constructor(
    private val charDetailsPresenter: CharDetailsPresenter
) : RainbowCakeViewModel<CharDetailsViewState>(Loading) {

    fun load(id: Long) = execute {
        viewState = Loading
        viewState = CharDetailsReady(charDetailsPresenter.getCharacter(id))
    }

    fun updateCharacter(character: BaseCharacter) = execute {
        viewState = Loading
        charDetailsPresenter.updateCharacter(character)
        viewState = Updated
    }

    fun saveToCloud(character: BaseCharacter) = execute {
        viewState = Loading
        viewState = CharCloudReady(charDetailsPresenter.saveToCloud(character))
    }

    fun deleteFromCloud(characterId: String) = execute {
        viewState = Loading
        charDetailsPresenter.deleteFromCloud(characterId)
        viewState = CloudDeleteReady
    }
}
