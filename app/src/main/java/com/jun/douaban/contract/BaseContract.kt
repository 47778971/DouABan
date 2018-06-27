package com.jun.douaban.contract

interface BaseContract {
    interface IModel<T> {

    }

    interface IView<T> {
        fun showDialog(content: String)
        fun dismissDialog()
        fun showToast(toast: String)
        fun showData(t: T)
    }

    interface IPresenter {

    }
}