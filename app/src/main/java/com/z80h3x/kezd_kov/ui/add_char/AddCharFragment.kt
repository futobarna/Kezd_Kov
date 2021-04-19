package com.z80h3x.kezd_kov.ui.add_char

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import kotlinx.android.synthetic.main.fragment_add_char.*

class AddCharFragment : RainbowCakeFragment<AddCharViewState, AddCharViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_add_char

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
    }

    private fun setupButtons() {
        addCharCancelButton.setOnClickListener {
            navigator?.pop()
        }
        addCharBackButton.setOnClickListener {
            navigator?.pop()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: AddCharViewState) {
        // TODO Render state
    }

}
