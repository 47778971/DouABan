package com.jun.douaban.api

import com.jun.douaban.entity.Film
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService{
    @GET("v2/movie/top250")
    fun getTop250(): Observable<Film>
}