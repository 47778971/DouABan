package com.jun.douaban.contract

import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack

interface Top250Contract {
    interface IModel {
        fun getTop250(httpCallBack: OnHttpCallBack)
    }

    interface IView {
        fun showDialog()
        fun dismissDialog()
        fun showData(films: Film)
    }

    interface IPresenter {
        fun present()
    }
}