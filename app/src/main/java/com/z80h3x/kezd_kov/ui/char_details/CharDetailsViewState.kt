package com.z80h3x.kezd_kov.ui.char_details

sealed class CharDetailsViewState

object Loading : CharDetailsViewState()

data class CharDetailsReady(val data: String = "") : CharDetailsViewState()
