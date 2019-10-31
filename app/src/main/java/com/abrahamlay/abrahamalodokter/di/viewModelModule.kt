package com.abrahamlay.abrahamalodokter.di

import com.abrahamlay.abrahamalodokter.ui.auth.AuthViewModel
import com.abrahamlay.abrahamalodokter.ui.home.HomeViewModel
import com.abrahamlay.abrahamalodokter.ui.profile.ProfileViewModel
import com.abrahamlay.data.datasource.UserDatabaseDataSourceImpl
import com.abrahamlay.data.datasource.UsersDatabaseDataSource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.Executors

/**
 * Created by Abraham Lay on 2019-10-30.
 */

val viewModelModule = module {
    viewModel{ AuthViewModel(get(),get()) }
    viewModel{ ProfileViewModel(get()) }
    viewModel{ HomeViewModel() }
}