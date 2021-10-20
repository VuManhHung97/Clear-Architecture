package com.vmh.cleararchitects.data.source

import com.vmh.cleararchitects.data.models.Post
import com.vmh.cleararchitects.data.models.User
import com.vmh.cleararchitects.data.source.local.LocalDataSource
import com.vmh.cleararchitects.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import java.util.concurrent.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) {
    fun login(id: Int): Flowable<User> {
        return remote.login(id)
    }

    fun postFromUser(userId: Int): Flowable<List<Post>> {
        return remote.posts(userId)
    }
}
