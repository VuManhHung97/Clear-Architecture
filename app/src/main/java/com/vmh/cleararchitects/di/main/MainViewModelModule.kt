package com.vmh.cleararchitects.di.main

import androidx.lifecycle.ViewModel
import com.vmh.cleararchitects.di.ViewModelKey
import com.vmh.cleararchitects.screen.main.information.InformationViewModel
import com.vmh.cleararchitects.screen.main.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(InformationViewModel::class)
    abstract fun bindInformationViewModel(viewModel: InformationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
}
