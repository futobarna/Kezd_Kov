package com.z80h3x.kezd_kov.ui.char_details

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class CharDetailsPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
