package com.mindera.rocketscience.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.mindera.rocketscience.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel(
    private val shechedulerProvider: SchedulerProvider
): ViewModel() {
    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun <T : Any> Maybe<T>.baseSubscribe(
        subscribeOn: Scheduler = shechedulerProvider.io(),
        observeOn: Scheduler = shechedulerProvider.ui(),
        onSuccess: (T) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    ) {
        onError.let {
            subscribeOn(subscribeOn).observeOn(observeOn)
                .subscribe({ onSuccess.invoke(it) }, { onError?.invoke(it) }).addToCompositeDisposable()
        }
    }

    @SuppressLint("CheckResult")
    fun <T: Any> Single<T>.baseSubscribe(
        subscribeOn: Scheduler = shechedulerProvider.io(),
        observeOn: Scheduler = shechedulerProvider.ui(),
        onSuccess: (T) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    ) {
        onError.let {
            if (onError != null) {
                subscribeOn(subscribeOn).observeOn(observeOn).subscribe(onSuccess, onError).addToCompositeDisposable()
            }
        }
    }

    fun <T : Any> Observable<T>.baseSubscribe(
        subscribeOn: Scheduler = shechedulerProvider.io(),
        observeOn: Scheduler = shechedulerProvider.ui(),
        onSuccess: (T) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    ) {
        onError.let {
            subscribeOn(subscribeOn).observeOn(observeOn).subscribe({ onSuccess.invoke(it) }, { onError?.invoke(it) }).addToCompositeDisposable()
        }
    }

    fun Completable.baseSubscribe(
        subscribeOn: Scheduler = shechedulerProvider.io(),
        observeOn: Scheduler = shechedulerProvider.ui(),
        onSuccess: () -> Unit,
        onError: ((Throwable) -> Unit)? = null
    ) {
        onError.let {
            if (onError != null) {
                subscribeOn(subscribeOn).observeOn(observeOn).subscribe(onSuccess, onError).addToCompositeDisposable()
            }
        }
    }

    private fun Disposable.addToCompositeDisposable() {
        disposable.add(this)
    }

}