package com.jun.douaban.util

import com.jun.douaban.api.ApiService

class ApiServiceHelper {
    companion object {
        fun getApiService(): ApiService {
            return RetrofitHelper.newInstance().create(ApiService::class.java)
        }
    }
}