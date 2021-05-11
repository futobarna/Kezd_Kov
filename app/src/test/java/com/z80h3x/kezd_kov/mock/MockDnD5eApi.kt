package com.z80h3x.kezd_kov.mock

import com.z80h3x.kezd_kov.data.network.apis.DnD5eAPI
import com.z80h3x.kezd_kov.data.network.models.Monster
import com.z80h3x.kezd_kov.data.network.models.MonsterList
import javax.inject.Inject

class MockDnD5eApi @Inject constructor() : DnD5eAPI {
    override suspend fun getAllMonsters(): MonsterList {
        return MonsterList(count = 1,
                results = arrayOf(Monster("axe-beak", "Axe Beak", "Large",
                        "beast", null, "unaligned", 11,
                        19, "3d10", null, null, 14,
                        12, 12, 2, 10, 5))
        )
    }

    override suspend fun getMonsterByName(monsterName: String): Monster {
        return Monster("axe-beak", "Axe Beak", "Large",
                "beast", null, "unaligned", 11,
                19, "3d10", null, null, 14,
                12, 12, 2, 10, 5)
    }
}