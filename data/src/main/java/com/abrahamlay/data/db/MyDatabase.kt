package com.abrahamlay.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abrahamlay.data.db.user.UserDao
import com.abrahamlay.data.db.user.UserData

/**
 * Created by Abraham Lay on 2019-10-30.
 */
@Database(entities = [UserData.User::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}