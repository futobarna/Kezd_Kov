package com.z80h3x.kezd_kov.ui.add_char

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import kotlinx.android.synthetic.main.fragment_add_char.*

class AddCharFragment : RainbowCakeFragment<AddCharViewState, AddCharViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_add_char

    private var monsterNames: MutableList<String>? = null
    private lateinit var nameSuggestionAdapter : ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
        setupRadioGroup()
    }

    private fun setupRadioGroup() {
        nameSuggestionAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
        addCharName.setAdapter(nameSuggestionAdapter)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                radioButtonDefault.id -> {
                    nameSuggestionAdapter.clear()
                    nameSuggestionAdapter.notifyDataSetChanged()
                }
                radioButtonAPI.id -> {
                    nameSuggestionAdapter.clear()
                    if (monsterNames == null){
                        viewModel.getMonsterNames()
                    } else {
                        nameSuggestionAdapter.addAll(monsterNames!!)
                        nameSuggestionAdapter.notifyDataSetChanged()
                    }
                }
                radioButtonCloud.id -> {
                    //TODO
                }
            }
        }
    }

    private fun setupButtons() {
        addCharCancelButton.setOnClickListener {
            navigator?.pop()
        }
        addCharBackButton.setOnClickListener {
            navigator?.pop()
        }
        addCharOkButton.setOnClickListener {
            val charName: String = addCharName.text.toString().trim()
            val initiativeString: String = addCharInitiative.text.toString().trim()
            val priorityString: String = addCharPriority.text.toString().trim()
            if (charName.isEmpty()) {
                addCharName.error = getString(R.string.empty_character_name_error)
                addCharName.requestFocus()
                return@setOnClickListener
            }
            if (initiativeString.isEmpty() || initiativeString.toIntOrNull() == null) {
                addCharInitiative.error = getString(R.string.invalid_number_field_error)
                addCharInitiative.requestFocus()
                return@setOnClickListener
            }
            if (priorityString.isEmpty() || priorityString.toIntOrNull() == null) {
                addCharPriority.error = getString(R.string.invalid_number_field_error)
                addCharPriority.requestFocus()
                return@setOnClickListener
            }

            val initiative: Int = initiativeString.toInt()
            val priority: Int = priorityString.toInt()

            viewModel.createCharacter(charName, initiative, priority)
        }
    }

    override fun render(viewState: AddCharViewState) {
        when (viewState) {
            is Form -> form()
            is Loading -> loading()
            is CharacterFailed -> characterFailed()
            is AddCharReady -> characterReady()
            is MonsterNamesReady -> monsterNamesReady(viewState)
        }
    }

    private fun monsterNamesReady(viewState: MonsterNamesReady) {
        nameSuggestionAdapter.addAll(viewState.monsterNames)
        nameSuggestionAdapter.notifyDataSetChanged()
        monsterNames = viewState.monsterNames
    }

    private fun characterReady() {
        addCharProgressBar.visibility = View.GONE
        textViewCharacterFailed.visibility = View.GONE
        navigator?.pop()
    }

    private fun characterFailed() {
        addCharProgressBar.visibility = View.GONE
        textViewCharacterFailed.visibility = View.VISIBLE
    }

    private fun form() {
        addCharProgressBar.visibility = View.GONE
        textViewCharacterFailed.visibility = View.GONE
    }

    private fun loading() {
        addCharProgressBar.visibility = View.VISIBLE
    }

}
