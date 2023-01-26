package com.vshum.reddit.data.db.entities

import com.google.gson.annotations.SerializedName

data class ResponseChildren (
    @SerializedName("kind")
    val kind: String,

    @SerializedName("data")
    val data: PostData
)