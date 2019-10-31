package com.abrahamlay.domain.usecase.user

import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import com.abrahamlay.domain.repository.user.UserRepository
import io.reactivex.Flowable
import com.abrahamlay.domain.common.transformer.STransformer

/**
 * Created by Abraham Lay on 2019-10-31.
 */

class GetUserUseCaseImpl(
    private val transformerSingle: STransformer<ResultState<Int>>,
    private val repository: UserRepository
) : GetUserUseCase {

    /**
     * Get all of users use case implementation
     */
    override fun getUser(params: GetUserUseCase.Params): Flowable<ResultState<Entity.User>> =
        repository.getUser(params.username, params.password)


}

