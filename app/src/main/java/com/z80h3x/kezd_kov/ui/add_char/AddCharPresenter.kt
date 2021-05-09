package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.withIOContext
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import javax.inject.Inject

class AddCharPresenter @Inject constructor(
    private val characterInteractor: CharacterInteractor
) {

    suspend fun createCharacter(
        name: String,
        initiative: Int,
        modifier: Int,
        description: String?
    ): Long? = withIOContext {
        return@withIOContext characterInteractor.insertCharacter(BaseCharacter(null, null, name, description, initiative, modifier))
    }

    suspend fun getMonsterNames(): MutableList<String> = withIOContext{
        return@withIOContext characterInteractor.getAllMonsters()
    }

    suspend fun getMonster(name: String) : BaseCharacter = withIOContext {
        return@withIOContext characterInteractor.getMonsterByName(name)
    }

}
