package com.jun.douaban.api

class ApiConstants {
    companion object {
        const val HOST: String = "https://api.douban.com/"
        const val TOP250: String = "v2/movie/top250"
        const val SUBJECT: String = "v2/movie/subject/{id}"
        const val CELEBRITY: String = "v2/movie/celebrity/{id}"
    }
}