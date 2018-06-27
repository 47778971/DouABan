package com.jun.douaban.presenter

import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.model.Top250Model

class Top250Presenter(view: BaseContract.IView<Film>) : BasePresenter<Film>(view) {
    fun getData() {
        view!!.showDialog()
        Top250Model().getData(object : OnHttpCallBack<Film> {
            override fun onSuccess(film: Film) {
                view!!.dismissDialog()
                view!!.showData(film)
            }

            override fun onFailure(code: Int, message: String?) {
                message?.let {
                    view!!.dismissDialog()
                    view!!.showToast(it)
                }
            }
        })
    }
}