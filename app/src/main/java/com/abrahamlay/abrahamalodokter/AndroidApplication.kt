package com.abrahamlay.abrahamalodokter

import android.app.Application
import android.content.Context
import com.abrahamlay.abrahamalodokter.di.dataModule
import com.abrahamlay.abrahamalodokter.di.useCaseModule
import com.abrahamlay.abrahamalodokter.di.viewModelModule
import com.abrahamlay.abrahamalodokter.ui.util.UtilSharedPreference
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Abraham Lay on 2019-10-30.
 */
class AndroidApplication : Application() {

    lateinit var editor: UtilSharedPreference

    override fun onCreate() {
        super.onCreate()
        instance = this
        editor = UtilSharedPreference(
            applicationContext,
            getSharedPreferences(PARAM_PREFS_NAME, Context.MODE_PRIVATE)
        )
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(
                listOf(
                    dataModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }


    }

    companion object {
        private const val PARAM_PREFS_NAME: String = "MyAppSharedPreference"

        private lateinit var instance: AndroidApplication
        @Synchronized
        internal fun getInstance(): AndroidApplication {
            return instance
        }
    }

}