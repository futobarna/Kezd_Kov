package com.z80h3x.kezd_kov.ui.char_details

import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter

sealed class CharDetailsViewState

object Loading : CharDetailsViewState()

data class CharDetailsReady(val character: RoomCharacter) : CharDetailsViewState()
