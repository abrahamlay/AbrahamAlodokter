package com.abrahamlay.domain.repository.user

import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import com.abrahamlay.domain.repository.BaseRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-10-30.
 */

interface UserRepository : BaseRepository {
    /**
     * Perform
     */
    fun getUser(username: String, password: String): Flowable<ResultState<Entity.User>>
    fun insertUser(user : Entity.User)

}