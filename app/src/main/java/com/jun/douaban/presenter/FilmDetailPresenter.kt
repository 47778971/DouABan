package com.jun.douaban.presenter

import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.model.FilmDetailModel
import com.jun.douaban.view.FilmDetailView

class FilmDetailPresenter(view: FilmDetailView) : BasePresenter(view) {
    fun getFilmDetail(id: String) {
        view!!.showDialog()
        FilmDetailModel().getFilmDetail(id, object : OnHttpCallBack<Film.SubjectsBean> {
            override fun onSuccess(film: Film.SubjectsBean) {
                view!!.dismissDialog()
                (view!! as FilmDetailView).showSubjectData(film)
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
        FilmDetailModel().getCastsDetail(id, object : OnHttpCallBack<Film.SubjectsBean.CastsBean> {
            override fun onSuccess(film: Film.SubjectsBean.CastsBean) {
                (view!! as FilmDetailView).showCastsData(film)
            }

            override fun onFailure(code: Int, message: String?) {
                message?.let {
                    view!!.showToast(it)
                }
            }
        })
    }


}