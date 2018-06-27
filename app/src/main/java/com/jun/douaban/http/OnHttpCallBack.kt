package com.jun.douaban.http

interface OnHttpCallBack<T> {
    fun onSuccess(t: T)
    fun onFailure(code: Int, message: String?)
}