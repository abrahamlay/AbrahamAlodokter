package com.abrahamlay.data.db.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.abrahamlay.data.db.BaseDao
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-10-30.
 */
@Dao
interface UserDao : BaseDao<UserData.User> {

    @Query("SELECT * FROM user_table WHERE id = :id")
    override fun select(id: Long): Flowable<UserData.User>

//    @Query("SELECT * FROM user_table ORDER BY id")
//    override fun selectAllPaged(): DataSource.Factory<Int, UserData.User>

    @Query("DELETE FROM user_table")
    override fun truncate()

    @Transaction
    fun replace(users: List<UserData.User>) {
        val firstId: Long = users.firstOrNull()?.id ?: run {
            0L
        }

        val lastId = users.lastOrNull()?.id ?: run {
            Long.MAX_VALUE
        }

        deleteRange(firstId, lastId)
        insert(users)
    }

    @Query("DELETE FROM user_table WHERE id BETWEEN :firstId AND :lastId")
    fun deleteRange(firstId: Long, lastId: Long)
}