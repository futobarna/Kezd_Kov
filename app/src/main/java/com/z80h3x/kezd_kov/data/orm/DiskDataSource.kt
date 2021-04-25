package com.z80h3x.kezd_kov.data.orm

import android.content.Context
import com.z80h3x.kezd_kov.data.orm.entities.Character
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(private val context: Context) {
    suspend fun getCharacterList() : MutableList<Character> = AppDatabase.getDatabase(context).characterDao().getAll().toMutableList()

    suspend fun getCharacter(characterId: Int) : Character = AppDatabase.getDatabase(context).characterDao().getCharacter(characterId)

    suspend fun insertCharacter(character: Character) : Long? = AppDatabase.getDatabase(context).characterDao().insert(character)

    suspend fun deleteCharacter(character: Character) = AppDatabase.getDatabase(context).characterDao().delete(character)
}