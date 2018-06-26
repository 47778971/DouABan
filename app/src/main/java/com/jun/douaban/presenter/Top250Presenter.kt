package com.jun.douaban.presenter

import com.jun.douaban.contract.Top250Contract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.model.Top250Model

class Top250Presenter : Top250Contract.IPresenter {

    var view: Top250Contract.IView? = null

    constructor(view: Top250Contract.IView) {
        this.view = view;
    }

    override fun getTop250() {
        view!!.showDialog()
        Top250Model().getTop250(object : OnHttpCallBack<Film> {
            override fun onSuccess(film: Film) {
                view!!.dismissDialog()
                view!!.showData(film)
            }

            override fun onFailure() {
                view!!.dismissDialog()
            }
        })
    }
}