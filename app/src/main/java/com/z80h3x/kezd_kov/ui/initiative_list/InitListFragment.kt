package com.z80h3x.kezd_kov.ui.initiative_list

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.ui.add_char.AddCharFragment
import com.z80h3x.kezd_kov.ui.char_details.CharDetailsFragment
import kotlinx.android.synthetic.main.fragment_init_list.*

class InitListFragment : RainbowCakeFragment<InitListViewState, InitListViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_init_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Setup views
        setupButtons()
    }

    private fun setupButtons() {
        initListAddButton.setOnClickListener {
            navigator?.add(AddCharFragment())
        }
        initListNextButton.setOnClickListener {
            //TODO create actual functionality
            navigator?.add(CharDetailsFragment())
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: InitListViewState) {
        // TODO Render state
    }

}
