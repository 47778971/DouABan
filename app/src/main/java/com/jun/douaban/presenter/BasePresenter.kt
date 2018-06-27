package com.jun.douaban.presenter

import com.jun.douaban.contract.BaseContract

open class BasePresenter : BaseContract.IPresenter {
    open var view: BaseContract.IView? = null

    constructor(view: BaseContract.IView) {
        this.view = view;
    }
}