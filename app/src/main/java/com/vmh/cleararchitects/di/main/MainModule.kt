package com.vmh.cleararchitects.di.main

import com.vmh.cleararchitects.di.scopes.MainScope
import com.vmh.cleararchitects.screen.main.posts.PostsAdapter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideAdapter(): PostsAdapter {
        return PostsAdapter()
    }

}
