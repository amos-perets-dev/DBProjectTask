package com.example.dbprojecttask.image_app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class ViewModelBase :
    ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    val showError = MutableLiveData<Int>()

    fun setError(error: Throwable) {

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}