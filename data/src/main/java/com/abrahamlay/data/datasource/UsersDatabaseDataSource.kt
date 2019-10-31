package com.abrahamlay.data.datasource

import com.abrahamlay.domain.entity.Entity
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-10-30.
 */
interface UsersDatabaseDataSource : BaseDataSource {

    fun getUser(username: String, password: String): Flowable<Entity.User>
    /**
     * Persist all of users in local database
     */
    fun persist(users: List<Entity.User>, insertFinished: () -> Unit)

    fun deleteUser(user: Entity.User)
}