package com.z80h3x.kezd_kov.mock

import com.z80h3x.kezd_kov.data.orm.daos.CharacterDao
import com.z80h3x.kezd_kov.data.orm.daos.MockCharacterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDiskModule {

    @Provides
    @Singleton
    fun provideMockCharDao(): CharacterDao {
        return MockCharacterDao()
    }
}