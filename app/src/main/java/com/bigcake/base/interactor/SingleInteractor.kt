package com.bigcake.base.interactor

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class SingleInteractor<T, in Parameters> : BaseInteractor<T>() {

    abstract protected fun buildUseCase(parameters: Parameters?): Single<T>

    open fun execute(onNext: (T) -> Unit, onError: (Throwable) -> Unit, params: Parameters? = null) {
        val single = buildUseCase(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        val disposable = single
                .subscribeWith(getDisposableSingleObserver(
                        onNext, onError))
        disposables.add(disposable)
    }

}
