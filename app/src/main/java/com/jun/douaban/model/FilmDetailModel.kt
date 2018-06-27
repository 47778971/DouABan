package com.jun.douaban.model

import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.util.ApiServiceHelper
import com.jun.douaban.util.RxHelper

class FilmDetailModel : BaseContract.IModel<Film.SubjectsBean> {
    fun getFilmDetail(id: String, httpCallBack: OnHttpCallBack<Film.SubjectsBean>) {
        RxHelper<Film.SubjectsBean>().subscribe(ApiServiceHelper.getApiService().getSubject(id), httpCallBack)
    }

    fun getCastsDetail(id: String, httpCallBack: OnHttpCallBack<Film.SubjectsBean.CastsBean>) {
        RxHelper<Film.SubjectsBean.CastsBean>().subscribe(ApiServiceHelper.getApiService().getCelebrity(id), httpCallBack)
    }
}