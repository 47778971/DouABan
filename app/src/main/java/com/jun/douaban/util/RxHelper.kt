package com.jun.douaban.util

import com.jun.douaban.http.OnHttpCallBack
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class RxHelper<T> {
    fun subscribe(observable: Observable<T>, httpCallBack: OnHttpCallBack<T>) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    httpCallBack.onSuccess(it)
                }, {
                    var code: Int = 0
                    var message: String? = null
                    if (it is HttpException) {
                        var httpException: HttpException = it as HttpException
                        code = httpException.code()
                        message = httpException.message()
                    }
                    httpCallBack.onFailure(code, message)
                })
    }
}