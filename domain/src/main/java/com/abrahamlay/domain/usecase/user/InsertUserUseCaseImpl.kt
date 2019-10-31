package com.abrahamlay.domain.usecase.user

import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.repository.user.UserRepository
import com.abrahamlay.domain.common.transformer.STransformer

/**
 * Created by Abraham Lay on 2019-10-31.
 */

class InsertUserUseCaseImpl(
    private val transformerSingle: STransformer<ResultState<Int>>,
    private val repository: UserRepository
) : InsertUserUseCase {

    /**
     * Insert user use case implementation
     */
    override fun insertUser(params: InsertUserUseCase.Params) {
        repository.insertUser(params.user)
    }


}

