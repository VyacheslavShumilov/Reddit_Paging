package com.vshum.reddit.entities

import com.google.gson.annotations.SerializedName

data class ResponseMainData (
    @SerializedName("after")
    val after: String,

    @SerializedName("children")
    val children: List<ResponseChildren>
)