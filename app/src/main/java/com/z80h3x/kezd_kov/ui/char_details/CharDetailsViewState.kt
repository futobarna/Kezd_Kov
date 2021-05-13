package com.z80h3x.kezd_kov.ui.char_details

import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter

sealed class CharDetailsViewState

object Loading : CharDetailsViewState()

data class CharDetailsReady(val character: BaseCharacter) : CharDetailsViewState()

data class CharCloudReady(val cloudId: String) : CharDetailsViewState()

object CloudDeleteReady: CharDetailsViewState()

object Updated: CharDetailsViewState()
