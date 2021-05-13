package com.z80h3x.kezd_kov

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.robolectric.shadows.ShadowLog

@ExperimentalCoroutinesApi
val InjectorOfTests: TestAppComponent
get() {
    ShadowLog.stream = System.out
    return DaggerTestAppComponent.builder().build()
}