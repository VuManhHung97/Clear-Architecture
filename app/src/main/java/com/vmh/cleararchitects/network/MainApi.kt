package com.vmh.cleararchitects.network

import com.vmh.cleararchitects.data.models.AccessToken
import com.vmh.cleararchitects.data.models.Post
import com.vmh.cleararchitects.data.models.User
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*


interface MainApi {

    @GET("https://jsonplaceholder.typicode.com/users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>

    @POST("refresh")
    @FormUrlEncoded
    fun refreshToken(@Field("refreshToken") refreshToken: String): Single<AccessToken>

    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getPostsFromUser(@Query("userId") id: Int): Flowable<List<Post>>
}
