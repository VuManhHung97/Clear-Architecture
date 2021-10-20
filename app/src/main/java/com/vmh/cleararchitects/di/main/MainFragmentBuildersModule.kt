package com.vmh.cleararchitects.di.main

import com.vmh.cleararchitects.screen.main.information.InformationFragment
import com.vmh.cleararchitects.screen.main.posts.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeInformationFragment(): InformationFragment

    @ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment

}
