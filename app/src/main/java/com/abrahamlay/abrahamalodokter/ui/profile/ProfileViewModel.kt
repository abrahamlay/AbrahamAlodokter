package com.abrahamlay.abrahamalodokter.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import com.abrahamlay.domain.usecase.user.GetUserUseCase
import com.abrahamlay.domain.usecase.user.InsertUserUseCase

/**
 * Created by Abraham Lay on 2019-10-31.
 */

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val getDetailMutable = MutableLiveData<ResultState<Entity.User>>()
    internal val getDetailData: LiveData<ResultState<Entity.User>>
        get() = getDetailMutable

    fun getDetails(username: String, password: String) {
        getUserUseCase.getUser(GetUserUseCase.Params(username, password)).subscribe { resultState ->
            (getDetailMutable::postValue)(resultState)
        }
    }
}