package com.abrahamlay.abrahamalodokter.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Abraham Lay on 2019-10-31.
 */
class BaseViewModel : ViewModel() {

    private val mDisposables = CompositeDisposable()

    protected fun Disposable.track() {
        mDisposables.add(this)
    }

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }

}