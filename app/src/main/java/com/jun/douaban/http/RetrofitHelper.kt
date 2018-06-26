package com.jun.douaban.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitHelper {
    private constructor() {

    }
    companion object {
        private var mRetrofit: Retrofit? = null
        fun newInstance(url: String): Retrofit {
            mRetrofit = null
            mRetrofit = Retrofit.Builder()
                    .client(OkHttpClient())
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return mRetrofit!!
        }
    }
}