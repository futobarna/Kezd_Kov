package com.z80h3x.kezd_kov.data.network.apis

import com.z80h3x.kezd_kov.data.network.models.Character
import retrofit2.http.*

interface IMockCharacterAPI {
    @GET("/character")
    suspend fun getAllCharacters(): Array<Character>

    @POST("/character")
    suspend fun addNewCharacter(
        @Body character: Character
    ) : String

    @PUT("/character")
    suspend fun updateCharacter(
        @Body character: Character
    ) : String

    @GET("/character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: String
    ) : Character

    @DELETE("/character/{characterId}")
    suspend fun deleteCharacter(
        @Path("characterId") characterId: String
    )
}