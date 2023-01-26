package com.vshum.reddit.ui

import androidx.paging.ExperimentalPagingApi
import com.vshum.reddit.data.api.ApiRepository
import com.vshum.reddit.data.db.CacheRepository

@ExperimentalPagingApi
class MainViewModel(private val cacheRepository: CacheRepository, private val apiRepository: ApiRepository) {
}