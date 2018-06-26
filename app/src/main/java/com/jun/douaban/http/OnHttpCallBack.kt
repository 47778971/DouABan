package com.jun.douaban.http

import com.jun.douaban.entity.Film

interface OnHttpCallBack {
    fun onSuccess(film: Film)
    fun onFailure()
}