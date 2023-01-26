package com.vshum.reddit.di

import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.vshum.reddit.data.api.ApiRepository
import com.vshum.reddit.data.api.ApiRequests
import com.vshum.reddit.data.api.RedditApiRepository
import com.vshum.reddit.data.db.CacheRepository
import com.vshum.reddit.data.db.DBConstants
import com.vshum.reddit.data.db.AppDB
import com.vshum.reddit.data.db.LocalCacheRepository
import com.vshum.reddit.data.api.RetrofitHelper
import com.vshum.reddit.windows.MainFragment
import com.vshum.reddit.windows.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

object Modules {
    //модуль, содержимое которого должно быть во всем приложении
    val application = module {
        //база данных
        single<AppDB>(qualifier = named(Scopes.DB)) {
            Room.databaseBuilder(get(), AppDB::class.java, DBConstants.NAME)
                .build()
        }
        single<CacheRepository>(qualifier = named(Scopes.DB_REPOSITORY)) {
            LocalCacheRepository(get(qualifier = named(Scopes.DB)))
        }

        //работа с api
        single<Retrofit>(qualifier = named(Scopes.RETROFIT)) {
            RetrofitHelper.create()
        }
        single<ApiRequests>(qualifier = named(Scopes.API)) {
            get<Retrofit>(qualifier = named(Scopes.RETROFIT)).create(ApiRequests::class.java)
        }
        single<ApiRepository>(qualifier = named(Scopes.API_REPOSITORY)) {
            RedditApiRepository(get(qualifier = named(Scopes.API)))
        }
    }

    //модуль основного экрана
    @ExperimentalPagingApi
    val mainWindow = module {
        scope<MainFragment> {
            viewModel(qualifier = named(Scopes.MAIN_VIEW_MODEL)) {
                MainViewModel(
                    get(qualifier = named(Scopes.DB_REPOSITORY)),
                    get(qualifier = named(Scopes.API_REPOSITORY)))
            }
        }
    }
}