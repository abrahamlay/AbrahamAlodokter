package com.abrahamlay.domain.usecase.user

import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-10-31.
 */

interface InsertUserUseCase {

    /**
     * Insert user use case
     * */
    fun insertUser(params: Params)


    data class Params(val user: Entity.User)
}