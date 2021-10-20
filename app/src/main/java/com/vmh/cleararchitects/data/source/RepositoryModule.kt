package com.vmh.cleararchitects.data.source

import com.vmh.cleararchitects.data.source.local.DAO
import com.vmh.cleararchitects.data.source.local.LocalDataModule
import com.vmh.cleararchitects.data.source.local.LocalDataSource
import com.vmh.cleararchitects.data.source.local.SharedPrefsApi
import com.vmh.cleararchitects.data.source.remote.RemoteDataModule
import com.vmh.cleararchitects.data.source.remote.RemoteDataSource
import com.vmh.cleararchitects.network.MainApi
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataModule::class, RemoteDataModule::class])
class RepositoryModule {

    @Provides
    fun providerBarberLocalDataSource(
        DAO: DAO,
        sharedPrefsApi: SharedPrefsApi
    ): LocalDataSource {
        return LocalDataSource(sharedPrefsApi, DAO)
    }

    @Provides
    fun providerBarberRemoteDataSource(mainApi: MainApi): RemoteDataSource {
        return RemoteDataSource(mainApi)
    }
}
