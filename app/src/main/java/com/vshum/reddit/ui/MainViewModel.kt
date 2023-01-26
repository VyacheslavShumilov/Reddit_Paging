package com.vshum.reddit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.vshum.reddit.AppConstants
import com.vshum.reddit.data.api.ApiRepository
import com.vshum.reddit.data.db.CacheRepository
import com.vshum.reddit.entities.PostData
import com.vshum.reddit.ui.service.MainPostsMediator

@ExperimentalPagingApi
class MainViewModel(private val cacheRepository: CacheRepository,
                    private val apiRepository: ApiRepository): ViewModel() {

    /** Получить liveData по постам */
    fun getPostsLiveData(): LiveData<PagingData<PostData>> {
        val posts = { cacheRepository.getPostsBeforeDate() }

        return Pager(
            config = getDefaultPageConfig(),
            pagingSourceFactory = posts,
            remoteMediator = MainPostsMediator(cacheRepository, apiRepository)
        ).liveData
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = AppConstants.LIMIT_POSTS, enablePlaceholders = false)
    }

}