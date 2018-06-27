package com.jun.douaban.model

import com.jun.douaban.api.ApiConstants
import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.util.ApiServiceHelper
import com.jun.douaban.util.RxHelper

class Top250Model : BaseContract.IModel<Film> {
    fun getData(httpCallBack: OnHttpCallBack<Film>) {
        RxHelper<Film>().subscribe(ApiServiceHelper.getApiService().getTop250(), httpCallBack)
    }
}