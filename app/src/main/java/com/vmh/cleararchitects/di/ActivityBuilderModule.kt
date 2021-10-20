package com.vmh.cleararchitects.di

import com.vmh.cleararchitects.di.auth.AuthViewModelModule
import com.vmh.cleararchitects.di.main.MainFragmentBuildersModule
import com.vmh.cleararchitects.di.main.MainModule
import com.vmh.cleararchitects.di.main.MainViewModelModule
import com.vmh.cleararchitects.di.scopes.AuthScope
import com.vmh.cleararchitects.di.scopes.MainScope
import com.vmh.cleararchitects.screen.auth.AuthActivity
import com.vmh.cleararchitects.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainViewModelModule::class, MainFragmentBuildersModule::class, MainModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}
