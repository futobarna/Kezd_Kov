package com.z80h3x.kezd_kov.data.orm.daos

import com.z80h3x.kezd_kov.data.orm.entities.RoomCharacter
import java.util.*
import javax.inject.Inject

class MockCharacterDao @Inject constructor() : IMockCharacterDao {
    override suspend fun getAll(): List<RoomCharacter> {
        return listOf(
                RoomCharacter(
                        id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
                        cloudId = null,
                        name = "Salazar",
                        description = "human fighter",
                        initiative = 12,
                        modifier = 2
                ),
                RoomCharacter(
                        id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
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
                id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
                cloudId = null,
                name = "Salazar",
                description = "human fighter",
                initiative = 12,
                modifier = 2
        )
    }

    override suspend fun insert(character: RoomCharacter): Long? {
        return UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
    }

    override suspend fun delete(character: RoomCharacter) {}
}