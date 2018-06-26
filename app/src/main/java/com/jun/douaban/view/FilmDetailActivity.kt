package com.jun.douaban.view

import android.app.Activity
import android.os.Bundle
import com.jun.douaban.R

class FilmDetailActivity : Activity() {

    companion object {
        val TITLE_EXTRA: String = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)
    }
}
