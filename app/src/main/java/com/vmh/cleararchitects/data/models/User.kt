package com.vmh.cleararchitects.data.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("username")
    @Expose
    var username: String? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null,
    @SerializedName("website")
    @Expose
    var website: String? = null
) : Parcelable
