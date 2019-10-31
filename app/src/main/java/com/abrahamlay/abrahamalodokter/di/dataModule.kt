package com.abrahamlay.abrahamalodokter.di

import androidx.room.Room
import com.abrahamlay.data.datasource.UserDatabaseDataSourceImpl
import com.abrahamlay.data.datasource.UsersDatabaseDataSource
import com.abrahamlay.data.db.MyDatabase
import com.abrahamlay.data.db.user.UserDao
import org.koin.dsl.module
import java.util.concurrent.Executors

/**
 * Created by Abraham Lay on 2019-10-30.
 */

val dataModule = module {
    single<UsersDatabaseDataSource> { UserDatabaseDataSourceImpl(get(), Executors.newSingleThreadExecutor()) }
    single<UserDao> { Room.databaseBuilder(get(), MyDatabase::class.java, "mydatabase")
        .build().userDao() }
}
