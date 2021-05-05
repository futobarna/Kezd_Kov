package com.z80h3x.kezd_kov.ui.char_details

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireLong
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import kotlinx.android.synthetic.main.fragment_char_details.*

class CharDetailsFragment : RainbowCakeFragment<CharDetailsViewState, CharDetailsViewModel> {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_char_details

    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(message = "Use newInstance instead", replaceWith = ReplaceWith("CharDetailsFragment.newInstance()"))
    constructor()

    companion object {
        private const val ARG_CHAR_ID = "characterId"

        @Suppress("DEPRECATION")
        fun newInstance(charId: Long): CharDetailsFragment {
            return CharDetailsFragment().applyArgs {
                putLong(ARG_CHAR_ID, charId)
            }
        }
    }

    private var characterId: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
        // TODO Setup views
        setupButtons()
    }

    private fun initArguments() {
        characterId = requireArguments().requireLong(ARG_CHAR_ID)
    }

    private fun setupButtons() {
        charDetailsBackButton.setOnClickListener {
            navigator?.pop()
        }
    }

    override fun onStart() {
        super.onStart()

        //viewModel.load()
    }

    override fun render(viewState: CharDetailsViewState) {
        // TODO Render state
    }

}
