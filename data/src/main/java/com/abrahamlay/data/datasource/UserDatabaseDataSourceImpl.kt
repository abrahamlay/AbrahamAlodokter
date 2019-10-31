package com.abrahamlay.data.datasource

import com.abrahamlay.data.db.user.UserDao
import com.abrahamlay.data.mapper.map
import com.abrahamlay.domain.entity.Entity
import io.reactivex.Flowable
import java.util.concurrent.Executor

/**
 * Created by Abraham Lay on 2019-10-30.
 */
class UserDatabaseDataSourceImpl(
    private val userDao: UserDao,
    private val ioExecutor: Executor
) : UsersDatabaseDataSource {

    /**
     * Get user by username from database implementation
     */
    override fun getUser(username: String, password: String): Flowable<Entity.User> =
        userDao.select(username, password)
            .map { it.map() }

    /**
     * Persist all of users in local database implementation
     */
    override fun persist(users: List<Entity.User>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            userDao.insert/*persist*/(users.map { it.map() })
            insertFinished()
        }
    }

    override fun deleteUser(user: Entity.User) {
        userDao.delete(user.map())
    }
}