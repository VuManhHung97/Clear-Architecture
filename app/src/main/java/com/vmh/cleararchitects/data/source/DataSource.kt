package com.vmh.cleararchitects.data.source

import com.vmh.cleararchitects.data.models.Post
import com.vmh.cleararchitects.data.models.User
import io.reactivex.Flowable

interface DataSource {
    interface LocalDataSource {
    }

    interface RemoteDataSource {
        fun login(id: Int): Flowable<User>
        fun posts(userId: Int): Flowable<List<Post>>
    }
}
