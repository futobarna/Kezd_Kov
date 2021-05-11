package com.z80h3x.kezd_kov

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.z80h3x.kezd_kov.di.AppComponent
import com.z80h3x.kezd_kov.di.ViewModelModule
import com.z80h3x.kezd_kov.mock.MockDiskModule
import com.z80h3x.kezd_kov.mock.MockNetworkModule
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
        MockDiskModule::class,
        RainbowCakeModule::class,
        ViewModelModule::class
    ]
)


@ExperimentalCoroutinesApi
interface TestAppComponent : AppComponent {
    fun inject(characterInteractorTest: CharacterInteractorTest)
}