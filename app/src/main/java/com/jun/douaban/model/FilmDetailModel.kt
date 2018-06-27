package com.jun.douaban.model

import com.jun.douaban.api.ApiService
import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.util.ApiServiceHelper
import com.jun.douaban.util.RetrofitHelper
import com.jun.douaban.util.RxHelper
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException


class FilmDetailModel : BaseContract.IModel {
    fun getFilmDetail(id: String, httpCallBack: OnHttpCallBack<Film.SubjectsBean>) {
        RxHelper<Film.SubjectsBean>().subscribe(ApiServiceHelper.getApiService().getSubject(id), httpCallBack)
    }

    fun getCastsDetail(id: String, httpCallBack: OnHttpCallBack<Film.SubjectsBean.CastsBean>) {
        RetrofitHelper.newInstance().create(ApiService::class.java).getSubject(id)
                .flatMap(Function<Film.SubjectsBean, ObservableSource<Film.SubjectsBean.CastsBean>> { film ->
                    ApiServiceHelper.getApiService().getCelebrity(id)
                }).subscribeOn(Schedulers.io())
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