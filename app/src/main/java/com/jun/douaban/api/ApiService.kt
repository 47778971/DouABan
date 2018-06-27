package com.jun.douaban.api

import com.jun.douaban.entity.Film
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(ApiConstants.TOP250)
    fun getTop250(): Observable<Film>

    @GET(ApiConstants.SUBJECT)
    fun getSubject(@Path("id") id: String): Observable<Film.SubjectsBean>

    @GET(ApiConstants.CELEBRITY)
    fun getCelebrity(@Path("id") id: String): Observable<Film.SubjectsBean.CastsBean>
}