package com.z80h3x.kezd_kov.mock

import com.z80h3x.kezd_kov.data.network.apis.DnD5eAPI
import com.z80h3x.kezd_kov.data.network.apis.IMockCharacterAPI
import com.z80h3x.kezd_kov.data.network.apis.MockCharacterApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideMockDnDApi(): DnD5eAPI {
        return MockDnD5eApi()
    }

    @Provides
    @Singleton
    fun provideMockCharApi(): IMockCharacterAPI {
        return MockCharacterApi()
    }
}