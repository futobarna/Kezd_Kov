package com.z80h3x.kezd_kov.ui.add_char

sealed class AddCharViewState

object Form : AddCharViewState()
object Loading : AddCharViewState()
object CharacterFailed : AddCharViewState()

data class AddCharReady(val characterId: Long) : AddCharViewState()

data class MonsterNamesReady(
    val monsterNames: MutableList<String>
) : AddCharViewState()
