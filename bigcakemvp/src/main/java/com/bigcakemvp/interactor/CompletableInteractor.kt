package com.bigcakemvp.interactor

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class CompletableInteractor<in Parameters> : BaseInteractor<Void>() {

    abstract fun buildUseCase(parameters: Parameters?): Completable

    open fun execute(onCompleted: () -> Unit, onError: (Throwable?) -> Unit, params: Parameters? = null) {
        val completable = buildUseCase(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        val disposable = completable
                .subscribeWith(getDisposableCompletableObserver(
                        onCompleted, onError))
        disposables.add(disposable)
    }
}
