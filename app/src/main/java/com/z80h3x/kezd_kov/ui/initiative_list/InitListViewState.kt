package com.z80h3x.kezd_kov.ui.initiative_list

import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter

sealed class InitListViewState

object Loading : InitListViewState()

data class InitListReady(val characters: MutableList<RoomCharacter>) : InitListViewState()
