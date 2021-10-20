package com.vmh.cleararchitects.di.auth

import androidx.lifecycle.ViewModel
import com.vmh.cleararchitects.di.ViewModelKey
import com.vmh.cleararchitects.screen.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

}