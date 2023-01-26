package com.vshum.reddit

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.vshum.reddit.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalPagingApi
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                Modules.application,
                Modules.mainWindow,
            )
        }
    }
}
