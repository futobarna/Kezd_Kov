package com.z80h3x.kezd_kov.data.orm.daos

import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import java.util.*
import javax.inject.Inject

class MockCharacterDao @Inject constructor() : IMockCharacterDao {
    override suspend fun getAll(): List<RoomCharacter> {
        return listOf(
                RoomCharacter(
                        id = 1,
                        cloudId = null,
                        name = "Salazar",
                        description = "human fighter",
                        initiative = 12,
                        modifier = 2
                ),
                RoomCharacter(
                        id = 2,
                        cloudId = null,
                        name = "Gary",
                        description = "dwarf bloodhunter",
                        initiative = 5,
                        modifier = 2
                )
        )
    }

    override suspend fun getCharacter(characterId: Long): RoomCharacter {
        return RoomCharacter(
                id = 1,
                cloudId = null,
                name = "Salazar",
                description = "human fighter",
                initiative = 12,
                modifier = 2
        )
    }

    override suspend fun insert(character: RoomCharacter): Long? {
        return 2
    }

    override suspend fun delete(character: RoomCharacter) {}
}