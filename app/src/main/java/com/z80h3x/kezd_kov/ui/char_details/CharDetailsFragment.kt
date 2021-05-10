package com.z80h3x.kezd_kov.ui.char_details

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireLong
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
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
    private var cloudId: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
        setupButtons()
    }

    private fun initArguments() {
        characterId = requireArguments().requireLong(ARG_CHAR_ID)
    }

    private fun setupButtons() {
        charDetailsBackButton.setOnClickListener {
            navigator?.pop()
        }
        charDetailsSaveButton.setOnClickListener {
            val character = BaseCharacter(
                id = characterId,
                cloudId = cloudId,
                name = charDetailsName.text.toString(),
                description = charDetailsDescription.text.toString(),
                initiative = charDetailsInitiative.text.toString().toInt(),
                modifier = charDetailsModifier.text.toString().toInt()
            )
            viewModel.updateCharacter(character)
        }
        charDetailsCloudButton.setOnClickListener {
            val character = BaseCharacter(
                    cloudId = cloudId,
                    name = charDetailsName.text.toString(),
                    description = charDetailsDescription.text.toString(),
                    modifier = null,
                    initiative = null,
                    id = null
            )
            viewModel.saveToCloud(character)
        }
        charDetailsCloudDeleteButton.setOnClickListener {
            viewModel.deleteFromCloud(cloudId!!)
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(characterId)
    }

    override fun render(viewState: CharDetailsViewState) {
        when (viewState) {
            is CharDetailsReady -> showCharDetailsReady(viewState)
            is Loading -> showLoading()
            is CharCloudReady -> showCloudReady(viewState)
            is CloudDeleteReady -> showCloudDeleteReady()
            is Updated -> showUpdated()
        }
    }

    private fun showUpdated() {
        charDetailsProgressBar.visibility = View.GONE
        charDetailsSaveButton.visibility = View.VISIBLE
        charDetailsCloudButton.visibility = View.VISIBLE

        if (cloudId == null)
            charDetailsCloudDeleteButton.visibility = View.GONE
        else
            charDetailsCloudDeleteButton.visibility = View.VISIBLE
    }

    private fun showCloudDeleteReady() {
        cloudId = null
        val character = BaseCharacter(
                id = characterId,
                cloudId = cloudId,
                name = charDetailsName.text.toString(),
                description = charDetailsDescription.text.toString(),
                initiative = charDetailsInitiative.text.toString().toInt(),
                modifier = charDetailsModifier.text.toString().toInt()
        )
        viewModel.updateCharacter(character)
    }

    private fun showCloudReady(viewState: CharCloudReady) {
        cloudId = viewState.cloudId
        val character = BaseCharacter(
                id = characterId,
                cloudId = cloudId,
                name = charDetailsName.text.toString(),
                description = charDetailsDescription.text.toString(),
                initiative = charDetailsInitiative.text.toString().toInt(),
                modifier = charDetailsModifier.text.toString().toInt()
        )
        viewModel.updateCharacter(character)
    }

    private fun showLoading() {
        charDetailsProgressBar.visibility = View.VISIBLE
        charDetailsSaveButton.visibility = View.GONE
        charDetailsCloudButton.visibility = View.GONE
        charDetailsCloudDeleteButton.visibility = View.GONE
    }

    private fun showCharDetailsReady(viewState: CharDetailsReady) {
        charDetailsProgressBar.visibility = View.GONE
        charDetailsSaveButton.visibility = View.VISIBLE
        charDetailsCloudButton.visibility = View.VISIBLE

        if (viewState.character.cloudId == null)
            charDetailsCloudDeleteButton.visibility = View.GONE
        else
            charDetailsCloudDeleteButton.visibility = View.VISIBLE

        charDetailsName.text = viewState.character.name
        charDetailsInitiative.setText(viewState.character.initiative.toString())
        charDetailsModifier.setText(viewState.character.modifier.toString())
        charDetailsDescription.setText(viewState.character.description)
        cloudId = viewState.character.cloudId
    }

}
