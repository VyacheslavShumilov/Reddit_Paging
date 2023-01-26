package com.vshum.reddit.data.db.entities

import com.google.gson.annotations.SerializedName

data class ResponseRoot (
    @SerializedName("kind")
    val kind: String,

    @SerializedName("data")
    val data: ResponseMainData
)
