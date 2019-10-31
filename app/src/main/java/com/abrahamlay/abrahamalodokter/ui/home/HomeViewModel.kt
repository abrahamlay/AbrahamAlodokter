package com.abrahamlay.abrahamalodokter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abrahamlay.abrahamalodokter.R
import com.abrahamlay.domain.common.ResultState

/**
 * Created by Abraham Lay on 2019-10-31.
 */
class HomeViewModel : ViewModel() {
    private val getListMutable = MutableLiveData<ResultState<ArrayList<Int>>>()
    internal val getListData: LiveData<ResultState<ArrayList<Int>>>
        get() = getListMutable

    fun getList() {
        val list = ArrayList<Int>()
        list.add(R.drawable.img_arsenal)
        list.add(R.drawable.img_acm)
        list.add(R.drawable.img_barca)
        list.add(R.drawable.img_bayern)
        list.add(R.drawable.img_chelsea)
        list.add(R.drawable.img_city)
        list.add(R.drawable.img_madrid)
        list.add(R.drawable.img_mu)
        getListMutable.postValue(ResultState.Success(list))
    }

}