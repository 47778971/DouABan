package com.jun.douaban.model

import com.jun.douaban.api.ApiService
import com.jun.douaban.contract.Top250Contract
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.http.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class Top250Model : Top250Contract.IModel {
    override fun getTop250(httpCallBack: OnHttpCallBack) {
        RetrofitHelper.newInstance("https://api.douban.com/")
                .create(ApiService::class.java).getTop250()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(Consumer {
                    httpCallBack.onSuccess(it)
                }, Consumer {
                    httpCallBack.onFailure()
                })
    }
}