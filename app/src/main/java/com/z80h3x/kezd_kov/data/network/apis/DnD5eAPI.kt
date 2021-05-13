package com.z80h3x.kezd_kov.data.network.apis

import com.z80h3x.kezd_kov.data.network.models.Monster
import com.z80h3x.kezd_kov.data.network.models.MonsterList
import retrofit2.http.GET
import retrofit2.http.Path

interface DnD5eAPI {
    @GET("/api/monsters")
    suspend fun getAllMonsters(): MonsterList

    @GET("/api/monsters/{monsterName}")
    suspend fun getMonsterByName(
        @Path("monsterName") monsterName: String
    ): Monster
}