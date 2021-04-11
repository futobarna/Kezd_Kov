package com.z80h3x.kezd_kov.ui.add_char

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class AddCharPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
