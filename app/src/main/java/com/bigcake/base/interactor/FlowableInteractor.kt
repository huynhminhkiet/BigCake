package com.bigcake.base.interactor

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class FlowableInteractor<T, in Parameters> : BaseInteractor<T>() {

    abstract fun buildUseCase(parameters: Parameters?): Flowable<T>

    fun execute(onNext: (T) -> Unit, onError: (Throwable) -> Unit, params: Parameters? = null) {
        val flowable = buildUseCase(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        val disposable = flowable
                .subscribeWith(getDisposableSubscriber(
                        onNext, onError))
        disposables.add(disposable)
    }

}
