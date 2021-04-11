package com.z80h3x.kezd_kov.ui.initiative_list

sealed class InitListViewState

object Loading : InitListViewState()

data class InitListReady(val data: String = "") : InitListViewState()
