package com.z80h3x.kezd_kov.ui.initiative_list

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.google.firebase.analytics.FirebaseAnalytics
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.ui.add_char.AddCharFragment
import com.z80h3x.kezd_kov.ui.char_details.CharDetailsFragment
import kotlinx.android.synthetic.main.fragment_init_list.*
import java.util.*

class InitListFragment : RainbowCakeFragment<InitListViewState, InitListViewModel>(), InitListAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_init_list

    private lateinit var adapter: InitListAdapter
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics

    private var sortDescending: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
        adapter = InitListAdapter(requireContext())
        setupButtons()
    }

    private fun setupButtons() {
        initListAddButton.setOnClickListener {
            navigator?.add(AddCharFragment())
        }
        initListNextButton.setOnClickListener {
            //throw RuntimeException("Test Crash")
            adapter.iterateHighlight()
            adapter.notifyDataSetChanged()
        }
        initListSortButton.setOnClickListener {
            sortDescending = !sortDescending
            adapter.changeHighlightToOpposite()
            viewModel.load(sortDescending)
            Handler(Looper.myLooper()!!).postDelayed({
                adapter.notifyDataSetChanged()}, 100)
        }
    }

    private fun setupList() {
        adapter.listener = this
        recyclerView.adapter = adapter
        recyclerView.itemAnimator?.changeDuration = 0
        recyclerView.itemAnimator?.moveDuration = 0
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
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, UUID.randomUUID().toString())
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, viewState.characters[0].name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "name")
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        initListProgressBar.visibility = View.GONE
        adapter.submitList(viewState.characters)
        Handler(Looper.myLooper()!!).postDelayed({
            adapter.notifyDataSetChanged()}, 100)
    }

    private fun showLoading() {
        initListProgressBar.visibility = View.VISIBLE
    }

    override fun onCharacterDelete(character: BaseCharacter, position: Int) {
        if (adapter.getHighlightPosition() > position)
            adapter.decreaseHighlightPosition()
        /*else if (character.id == adapter.getItemId(adapter.getHighlightPosition())) {
            adapter.iterateHighlight()
            adapter.notifyDataSetChanged()
        }*/
        viewModel.deleteCharacter(character, sortDescending)
    }

    override fun onItemSelected(id: Long) {
        navigator?.add(CharDetailsFragment.newInstance(id))
    }

}
