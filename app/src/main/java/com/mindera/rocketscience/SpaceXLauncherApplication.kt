package com.mindera.rocketscience

import android.app.Application
import com.mindera.rocketscience.data.di.apiModule
import com.mindera.rocketscience.data.di.repositoryModule
import com.mindera.rocketscience.di.viewModelModule
import com.mindera.rocketscience.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class SpaceXLauncherApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SpaceXLauncherApplication)
            modules(
                useCaseModule,
                viewModelModule,
                repositoryModule,
                apiModule
            )
        }
    }
}