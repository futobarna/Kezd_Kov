package com.z80h3x.kezd_kov.ui.initiative_list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.ui.add_char.AddCharFragment
import com.z80h3x.kezd_kov.ui.char_details.CharDetailsFragment
import kotlinx.android.synthetic.main.fragment_init_list.*

class InitListFragment : RainbowCakeFragment<InitListViewState, InitListViewModel>(), InitListAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_init_list

    private lateinit var adapter: InitListAdapter

    private var sortDescending: Boolean = true

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

        }
        initListSortButton.setOnClickListener {
            sortDescending = !sortDescending
            viewModel.load(sortDescending)
        }
    }

    private fun setupList() {
        adapter = InitListAdapter(requireContext())
        adapter.listener = this
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(sortDescending)
    }

    override fun render(viewState: InitListViewState) {
        when (viewState) {
            is InitListReady -> showInitListPage(viewState)
            is Loading -> showLoading()
        }
    }

    private fun showInitListPage(viewState: InitListReady) {
        setupList()
        initListProgressBar.visibility = View.GONE
        adapter.submitList(viewState.characters)
    }

    private fun showLoading() {
        initListProgressBar.visibility = View.VISIBLE
    }

    override fun onCharacterDelete(character: BaseCharacter) {
        viewModel.deleteCharacter(character, sortDescending)
    }

    override fun onItemSelected(id: Long) {
        navigator?.add(CharDetailsFragment.newInstance(id))
    }

}
