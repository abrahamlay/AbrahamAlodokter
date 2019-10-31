package com.abrahamlay.domain.usecase.user

import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-10-31.
 */

interface GetUserUseCase {

    /**
     * Get user by username use case
     * */
    fun getUser(params: Params): Flowable<ResultState<Entity.User>>


    data class Params(val username: String, val password: String)
}