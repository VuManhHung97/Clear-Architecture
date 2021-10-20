package com.vmh.cleararchitects.di

import androidx.lifecycle.ViewModelProvider
import com.vmh.cleararchitects.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}
