package com.z80h3x.kezd_kov

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.z80h3x.kezd_kov.ui.blank.BlankFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(BlankFragment())
        }
    }

}
