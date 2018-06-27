package com.jun.douaban.view

import com.jun.douaban.contract.BaseContract

interface FilmDetailView : BaseContract.IView {
    fun <T> showSubjectData(t: T)
    fun <T> showCastsData(t: T)
}