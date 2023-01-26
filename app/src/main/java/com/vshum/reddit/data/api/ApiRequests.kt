package com.vshum.reddit.data.api

import com.vshum.reddit.AppConstants
import com.vshum.reddit.data.entities.ResponseRoot
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequests {
    /** Получить список постов */
    @GET("popular.json")
    suspend fun getPosts(@Query("limit") limit: Int = AppConstants.LIMIT_POSTS,
                         @Query("after") after: String? = null,
                         @Query("before") before: String? = null): ResponseRoot
}