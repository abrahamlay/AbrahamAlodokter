package com.abrahamlay.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update
import io.reactivex.Flowable


/**
 * Created by Abraham Lay on 2019-10-30.
 */
interface BaseDao<T> {
    fun select(id: Long): Flowable<T>

    fun select(username: String, password: String): Flowable<T>

//    fun selectAllPaged(): DataSource.Factory<Int, T>

    @Insert(onConflict = IGNORE)
    fun insert(t: T): Long

    @Insert(onConflict = REPLACE)
    fun insert(ts: List<T>)

    @Update(onConflict = REPLACE)
    fun update(t: T)

    @Update(onConflict = REPLACE)
    fun update(ts: List<T>)

    @Delete
    fun delete(t: T): Unit

    @Delete
    fun delete(ts: List<T>)

    fun truncate()
}