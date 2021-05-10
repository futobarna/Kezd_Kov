package com.z80h3x.kezd_kov.ui.add_char

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import kotlinx.android.synthetic.main.fragment_add_char.*
import java.util.*

class AddCharFragment : RainbowCakeFragment<AddCharViewState, AddCharViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_add_char

    private var monsterNames: MutableList<String>? = null
    private var cloudNames: MutableList<String>? = null
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
                    addCharPriority.visibility = View.VISIBLE
                    addCharInitiative.visibility = View.VISIBLE
                    addCharTextPriority.visibility = View.VISIBLE
                    addCharTextInitiative.visibility = View.VISIBLE
                    addCharDnDAPIHint.visibility = View.GONE
                    nameSuggestionAdapter.clear()
                    nameSuggestionAdapter.notifyDataSetChanged()
                }
                radioButtonAPI.id -> {
                    addCharPriority.visibility = View.GONE
                    addCharInitiative.visibility = View.GONE
                    addCharTextPriority.visibility = View.GONE
                    addCharTextInitiative.visibility = View.GONE
                    addCharDnDAPIHint.visibility = View.VISIBLE
                    nameSuggestionAdapter.clear()
                    if (monsterNames == null){
                        viewModel.getMonsterNames()
                    } else {
                        nameSuggestionAdapter.addAll(monsterNames!!)
                        nameSuggestionAdapter.notifyDataSetChanged()
                    }
                }
                radioButtonCloud.id -> {
                    addCharPriority.visibility = View.VISIBLE
                    addCharInitiative.visibility = View.VISIBLE
                    addCharTextPriority.visibility = View.VISIBLE
                    addCharTextInitiative.visibility = View.VISIBLE
                    nameSuggestionAdapter.clear()
                    if (cloudNames == null){
                        viewModel.getCloudNames()
                    } else {
                        nameSuggestionAdapter.addAll(cloudNames!!)
                        nameSuggestionAdapter.notifyDataSetChanged()
                    }
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
            when (radioGroup.checkedRadioButtonId) {
                radioButtonDefault.id -> {
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

                    viewModel.createCharacter(charName, initiative, priority, null, null)
                }
                radioButtonAPI.id -> {
                    if (charName.isEmpty()) {
                        addCharName.error = getString(R.string.empty_character_name_error)
                        addCharName.requestFocus()
                        return@setOnClickListener
                    }
                    viewModel.getMonster(charName.toLowerCase(Locale.getDefault()).replace(' ', '-').replace("\'",""))
                }
                radioButtonCloud.id -> {
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
                    viewModel.getCloudCharacters(charName
                            .toLowerCase(Locale.getDefault())
                            .replace(' ', '-')
                            .replace("\'", "")
                    )
                }
            }
        }
    }

    override fun render(viewState: AddCharViewState) {
        when (viewState) {
            is Form -> form()
            is Loading -> loading()
            is CharacterFailed -> characterFailed()
            is AddCharReady -> characterReady()
            is MonsterNamesReady -> monsterNamesReady(viewState)
            is MonsterReady -> monsterReady(viewState)
            is CloudNamesReady -> cloudNamesReady(viewState)
            is CloudCharReady -> cloudCharReady(viewState)
        }
    }

    private fun cloudCharReady(viewState: CloudCharReady) {
        addCharProgressBar.visibility = View.GONE
        val initiativeString: String = addCharInitiative.text.toString().trim()
        val priorityString: String = addCharPriority.text.toString().trim()
        if (initiativeString.isEmpty() || initiativeString.toIntOrNull() == null) {
            addCharInitiative.error = getString(R.string.invalid_number_field_error)
            addCharInitiative.requestFocus()
            return
        }
        if (priorityString.isEmpty() || priorityString.toIntOrNull() == null) {
            addCharPriority.error = getString(R.string.invalid_number_field_error)
            addCharPriority.requestFocus()
            return
        }
        val initiative: Int = initiativeString.toInt()
        val priority: Int = priorityString.toInt()
        viewModel.createCharacter(viewState.character.name, initiative, priority,
                viewState.character.description, viewState.character.cloudId)
    }

    private fun cloudNamesReady(viewState: CloudNamesReady) {
        addCharProgressBar.visibility = View.GONE
        nameSuggestionAdapter.addAll(viewState.cloudNames)
        nameSuggestionAdapter.notifyDataSetChanged()
        cloudNames = viewState.cloudNames
    }

    private fun monsterReady(viewState: MonsterReady) {
        addCharProgressBar.visibility = View.GONE
        val roll = (1..20).random()
        viewModel.createCharacter(viewState.character.name,
                roll + viewState.character.modifier!!,
                viewState.character.modifier,
                viewState.character.description,
                null
        )
    }

    private fun monsterNamesReady(viewState: MonsterNamesReady) {
        addCharProgressBar.visibility = View.GONE
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
