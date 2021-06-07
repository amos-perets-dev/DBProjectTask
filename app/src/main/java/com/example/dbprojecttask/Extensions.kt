package com.example.dbprojecttask

import io.reactivex.Observable
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.subscribePro(): Disposable {
    return subscribe({}, Throwable::printStackTrace)
}