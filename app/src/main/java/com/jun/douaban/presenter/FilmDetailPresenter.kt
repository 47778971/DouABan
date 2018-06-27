package com.jun.douaban.presenter

import com.jun.douaban.contract.BaseContract
import com.jun.douaban.entity.Film
import com.jun.douaban.http.OnHttpCallBack
import com.jun.douaban.model.FilmDetailModel

class FilmDetailPresenter(view: BaseContract.IView<Film.SubjectsBean>) : BasePresenter<Film.SubjectsBean>(view) {
    fun getFilmDetail(id: String) {
        view!!.showDialog("获取影片详情")
        FilmDetailModel().getFilmDetail(id, object : OnHttpCallBack<Film.SubjectsBean> {
            override fun onSuccess(film: Film.SubjectsBean) {
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