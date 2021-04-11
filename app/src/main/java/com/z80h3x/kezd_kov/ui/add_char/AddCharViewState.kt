package com.z80h3x.kezd_kov.ui.add_char

sealed class AddCharViewState

object Loading : AddCharViewState()

data class AddCharReady(val data: String = "") : AddCharViewState()
