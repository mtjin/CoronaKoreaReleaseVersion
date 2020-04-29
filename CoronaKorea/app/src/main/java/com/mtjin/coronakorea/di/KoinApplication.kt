package com.mtjin.coronakorea.di

import android.app.Application
import com.mtjin.coronakorea.BuildConfig
import com.mtjin.coronakorea.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            } else {
                androidLogger(Level.NONE)
            }
            androidContext(this@KoinApplication)
            modules(
                apiModule,
                viewModelModule,
                localDataModule,
                remoteModule,
                repositoryModule,
                networkModule
            )

        }
    }
}