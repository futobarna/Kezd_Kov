package com.z80h3x.kezd_kov.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import com.z80h3x.kezd_kov.ui.add_char.AddCharViewModel
import com.z80h3x.kezd_kov.ui.char_details.CharDetailsViewModel
import com.z80h3x.kezd_kov.ui.initiative_list.InitListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(InitListViewModel::class)
    abstract fun bindInitListViewModel(initListViewModel: InitListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharDetailsViewModel::class)
    abstract fun bindCharDetailsViewModel(charDetailsViewModel: CharDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddCharViewModel::class)
    abstract fun bindAddCharViewModel(addCharViewModel: AddCharViewModel): ViewModel

}
