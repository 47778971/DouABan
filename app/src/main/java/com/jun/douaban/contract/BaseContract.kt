package com.jun.douaban.contract

interface BaseContract {
    interface IModel {

    }

    interface IView {
        fun showDialog()
        fun dismissDialog()
        fun showToast(toast: String)
        fun <T> showData(t: T)
    }

    interface IPresenter {

    }
}