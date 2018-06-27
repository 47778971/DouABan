package com.jun.douaban.presenter

import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.model.FilmDetailModel

class FilmDetailPresenter(view: BaseContract.IView<Film.SubjectsBean.CastsBean>) : BasePresenter<Film.SubjectsBean.CastsBean>(view) {
    fun getFilmDetail(id: String) {
        view!!.showDialog()
        FilmDetailModel().getCastsDetail(id, object : OnHttpCallBack<Film.SubjectsBean.CastsBean> {
            override fun onSuccess(film: Film.SubjectsBean.CastsBean) {
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

    fun getCastsDetail(id: String) {
        view!!.showDialog()
        FilmDetailModel().getCastsDetail(id, object : OnHttpCallBack<Film.SubjectsBean.CastsBean> {
            override fun onSuccess(film: Film.SubjectsBean.CastsBean) {
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