package com.z80h3x.kezd_kov.ui.add_char

import com.z80h3x.kezd_kov.data.generic.BaseCharacter

sealed class AddCharViewState

object Form : AddCharViewState()
object Loading : AddCharViewState()
object CharacterFailed : AddCharViewState()

data class AddCharReady(val characterId: Long) : AddCharViewState()

data class MonsterNamesReady(val monsterNames: MutableList<String>) : AddCharViewState()

data class MonsterReady(val character: BaseCharacter) : AddCharViewState()

data class CloudNamesReady(val cloudNames: MutableList<String>) : AddCharViewState()

data class CloudCharReady(val character: BaseCharacter) : AddCharViewState()
