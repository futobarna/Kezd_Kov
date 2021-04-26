package com.z80h3x.kezd_kov.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.z80h3x.kezd_kov.data.network.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : RainbowCakeComponent
