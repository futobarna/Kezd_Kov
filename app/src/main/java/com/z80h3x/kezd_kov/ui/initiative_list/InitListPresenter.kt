package com.z80h3x.kezd_kov.ui.initiative_list

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class InitListPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
