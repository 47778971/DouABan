package com.jun.douaban.presenter

import com.jun.douaban.contract.BaseContract

open class BasePresenter<T> : BaseContract.IPresenter {
    open var view: BaseContract.IView<T>? = null

    constructor(view: BaseContract.IView<T>) {
        this.view = view;
    }
}