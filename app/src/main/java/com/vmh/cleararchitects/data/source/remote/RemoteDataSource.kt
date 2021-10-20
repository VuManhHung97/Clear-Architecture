package com.vmh.cleararchitects.data.source.remote

import com.vmh.cleararchitects.data.models.Post
import com.vmh.cleararchitects.data.models.User
import com.vmh.cleararchitects.data.source.DataSource
import com.vmh.cleararchitects.network.MainApi
import io.reactivex.Flowable
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val mainApi: MainApi) :
    DataSource.RemoteDataSource {
    override fun login(id: Int): Flowable<User> {
        return mainApi.getUser(id)
    }

    override fun posts(userId: Int): Flowable<List<Post>> {
        return mainApi.getPostsFromUser(userId)
    }
}
