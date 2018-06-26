package com.jun.douaban.contract

import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack

interface Top250Contract {
    interface IModel {
        fun getTop250(httpCallBack: OnHttpCallBack<Film>)
    }

    interface IView {
        fun showDialog()
        fun dismissDialog()
        fun showData(film: Film)
    }

    interface IPresenter {
        fun getTop250()
    }
}