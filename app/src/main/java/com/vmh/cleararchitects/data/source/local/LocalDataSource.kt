package com.vmh.cleararchitects.data.source.local

import com.vmh.cleararchitects.data.source.DataSource
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val sharedPrefsApi: SharedPrefsApi,
    private val photoDAO: DAO
): DataSource.LocalDataSource {

}
